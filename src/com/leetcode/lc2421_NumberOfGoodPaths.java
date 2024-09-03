package com.leetcode;

import java.util.Arrays;

/**
 * 这道题规则理解起来不难。<br />
 * 但难的是怎么独立研究出这个规则。<br />
 * <hr>
 * 并查集多了一个伴生的属性数组<br />
 * 自身的集合也有一定的意义改变<br />
 * <hr>
 * 原生的father数组原本是随便存个元素就可以，<br />
 * 现在得存集合中的最大值。<br />
 * 此外还多出了用于存储每个值所属集合最大值个数的数组maxcnt。<br />
 * <hr>
 * 所以单单从数组的设定你就能看出求解这道题的思路。<br />
 * 只有最大值相等的两个集合才能产生题目说要求的好路径！<br />
 * 如果再想办法从小遍历，那就几乎可以涵盖所有的可能的好路径！<br />
 * <hr>
 * 于是，这样的思路体现在union里<br />
 * 如果要合并的两个集合根值不等？<br />
 * 那就小挂大。<br />
 * 如果相等？<br />
 * 才计算一次好路径<br />
 * 同时更新father和maxcnt<br />
 * 并且返回好路径的条数path<br />
 * <hr>
 * 最后，根据题目设定可知：<br />
 * 好路径包括自指<br />
 * 所以总条数就是节点数+union过程中计算出的路径数。<br />
 *
 * @author Yabo
 * @date 2024/09/03
 */
class lc2421_NumberOfGoodPaths {

    public static int MAXN = 30001;

    // 需要保证集合中，代表节点的值，一定是整个集合的最大值
    public static int[] father = new int[MAXN];

    // 集合中最大值的次数，也就是 集合中代表节点的值有几个
    public static int[] maxcnt = new int[MAXN];


    public static void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
            // 初始化成这样，也相当好理解
            // 每个集合初始设为最大值是自己，也就只有1个
            maxcnt[i] = 1;
        }
    }

    // 这个并查集的优化只来自扁平化
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    // 核心！
    // 注意以下的写法！
    // 谁的值大，谁做代表节点
    // 同时注意 maxcnt 的更新
    public static int union(int x, int y, int[] vals) {
        // fx : x所在集团的代表节点，同时也是x所在集团的最大值下标
        int fx = find(x);
        // fy : y所在集团的代表节点，同时也是y所在集团的最大值下标
        int fy = find(y);
        int path = 0;
        if (vals[fx] > vals[fy]) {
            father[fy] = fx;
        } else if (vals[fx] < vals[fy]) {
            father[fx] = fy;
        } else {
            // 两个集团最大值一样！
            path = maxcnt[fx] * maxcnt[fy];
            // 这应该是随便挂一个的
            father[fy] = fx;
            // 别忘了还要更新合并后集合的最大值个数
            maxcnt[fx] += maxcnt[fy];
        }
        // 多了一个之前从未有过的返回值
        // sodayo，并查集的潜力大着呢！
        return path;
    }


    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // 1. 获取点数
        int n = vals.length;
        // 2. 初始化并查集结构
        build(n);
        // 3. 先设置答案变量并初始化一下
        int ans = n;

        // 4. 排序，
        // 目的是先处理所有构成边的两个端点的最大值最小的那些边。
        // 其中，同级别的处理顺序随意，不同级别的按从小到大处理。
        // Comparator.comparingInt 这玩意好慢！
        Arrays.sort(edges, (e1, e2) -> (Math.max(vals[e1[0]], vals[e1[1]]) - Math.max(vals[e2[0]], vals[e2[1]])));
        // 5. for循环，结束后可得ans
        for (int[] edge : edges) {
            // 	循环所有边。
            // 	把所有有边联系的两个点调用union子函数。
            // 	最终所有点都会在同一个集合里，
            // 	所以合并不是目的，
            // 	重要的是，我们在合并过程中所做的操作。
            ans += union(edge[0], edge[1], vals);
        }
        // 6. 返回ans即可。
        return ans;
    }
}
