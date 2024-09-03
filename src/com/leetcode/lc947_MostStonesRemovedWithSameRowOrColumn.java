package com.leetcode;

import java.util.HashMap;

/**
 * 四道题在我脑子清晰的情况下还是可以理解的。<br />
 * 难度评价为中等。<br />
 * <hr>
 * 并查集的三个方法随题目不同进行微调。<br />
 * 譬如在这个方法里加一行、那个方法加一行。<br />
 * 可改造性还是挺足的。<br />
 * <hr>
 * 还是 build、find、union<br />
 * <hr>
 * 先说最后的答案怎么计算的。<br />
 * 把每个群落的石子合并成各自的集合后<br />
 * 按规则来说，就能消成一个！<br />
 * 于是可以移除的最大石子数量<br />
 * 就是石子总数n-集合数量sets<br />
 * <hr>
 * 然后说下核心科技<br />
 * 设计两个map，<br />
 * 分别用来存储在遍历二维矩阵时第一次在各行各列第一次遇到的石子。<br />
 * 而当第二次在这行或这列遇到另一个石子时，<br />
 * 根据规则，<br />
 * 就可以把它与第一次那个合并成一个集合。<br />
 * <hr>
 * 行和列并行地都这么操作一下。<br />
 * sets就有啦！<br />
 *
 * @author Yabo
 * @date 2024/09/02
 */
class lc947_MostStonesRemovedWithSameRowOrColumn {

    public static HashMap<Integer, Integer> rowFirst = new HashMap<>();

    public static HashMap<Integer, Integer> colFirst = new HashMap<>();

    public static int MAXN = 1001;

    public static int[] father = new int[MAXN];

    public static int sets = 0;

    public static void build(int n) {
        // 1. 初始化rowMap、colMap
        rowFirst.clear();
        colFirst.clear();
        // 2. 并查集经典初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        // 3. 初始化集合个数变量
        sets = n;
    }

    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            father[fx] = fy;
            sets--;
        }
    }

    public int removeStones(int[][] stones) {
        // 1. 获取石子数（由题可知，石子分布在一个正方形矩阵中
        int n = stones.length;
        // 2. 初始化并查集结构
        build(n);
        // 3. for循环，循环每个石子，结果可得最后的集合数
        for (int i = 0, x, y; i < n; i++) {
            // 	1. 取出每个石子的x、y坐标
            x = stones[i][0];
            y = stones[i][1];
            // 	2. 检查map，如果是第一次在这行或列上遇到石子，加入map
            // 	否则，与第一次遇到的石子的集合合并。
            if (!rowFirst.containsKey(x)) {
                rowFirst.put(x, i);
            } else {
                union(i, rowFirst.get(x));
            }

            if (!colFirst.containsKey(y)) {
                colFirst.put(y, i);
            } else {
                union(i, colFirst.get(y));
            }

        }
        // 4. 返回答案
        return n - sets;
    }
}
