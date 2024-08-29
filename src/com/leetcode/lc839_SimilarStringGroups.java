package com.leetcode;

/**
 * 核心逻辑反倒很简单<br />
 * 并查集并非注意力焦点<br />
 * <hr>
 * 对每个字符串构建集合，如果每两个字符串差异度是2或0，就认为是相似的。<br />
 * 就得被合并为一组，反而答案的数量在减少。<br />
 *
 * @author Yabo
 * @date 2024/08/29
 */
class lc839_SimilarStringGroups {

    public static int MAXN = 301;

    public static int[] father = new int[MAXN];

    public static int sets;

    public static void build(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        // 初始化集合数量
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
            // 合并了就要减小，这理所当然。
            sets--;
        }
    }

    public int numSimilarGroups(String[] strs) {
        // 1. 获取字符串数组数量
        int n = strs.length;
        // 2. 获取字符串的长度
        int m = strs[0].length();
        // 3. 对每个字符串构建集合
        build(n);
        // 4. 双层for循环，完毕后即得字符组中有多少相似性组。
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //     1. 如果每两个字符串不是同一组，则开始计算差异度。
                if (find(i) != find(j)) {
                    int diff = 0;
                    for (int k = 0; k < m && diff < 3; k++) {
                        if (strs[i].charAt(k) != strs[j].charAt(k)) {
                            diff++;
                        }
                    }
                    //     2. 如果每两个字符串差异度是2或0，则视作相似，进行合并。
                    if (diff == 0 || diff == 2) {
                        union(i, j);
                    }
                }
            }
        }
        // 5. 返回答案。
        return sets;

    }
}
