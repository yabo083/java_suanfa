package com.leetcode;

/**
 * 惊险的一跃是：如何得出有n对乱序的情侣，就得调整n-1次这个规律。<br />
 * 而且需要阅读理解的地方是：<br />
 * 这道题默认0、1是第1对、2、3是第2对……<br />
 * 人的序号/2,即得他的天命情侣位次。<br />
 * <hr>
 * 解法是：求出最后剩几个集合（开始集合对数等于情侣对数），拿情侣对数一减即可。<br />
 * <hr>
 * 这就得利用合并操作，合并的标准是什么呢？<br />
 * 如何邻座的两人天命情侣位次不一致，那就合并（同时集合对数--）<br />
 * <hr>
 * over！<br />
 *
 * @author Yabo
 * @date 2024/08/29
 */
class lc765_CouplesHoldingHands {

    public static int MAXN = 31;
    public static int[] father = new int[MAXN];
    public static int sets;

    public static void build(int m) {
        for (int i = 0; i < m; i++) {
            father[i] = i;
        }
        sets = m;
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

    public int minSwapsCouples(int[] row) {
        // 1. 获取人数
        int n = row.length;
        // 2. 把情侣对数传入并查集初始化函数
        build(n / 2);
        // 3. for循环，完毕后集合操作完毕。
        for (int i = 0; i < n; i += 2) {
            //     1. 以2为步调，依次对邻座执行合并操作。
            //     2. 放心，第二个参数不会造成越界！
            union(row[i] / 2, row[i + 1] / 2);
        }
        // 4. 返回最后结果。
        return n / 2 - sets;
    }


}
