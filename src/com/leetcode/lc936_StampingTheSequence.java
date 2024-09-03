package com.leetcode;

import java.util.Arrays;

/**
 * 有机会再听一次吧，我什么都会做的！
 *
 * @author Yabo
 * @date 2024/09/03
 */
class lc936_StampingTheSequence {

    public static int N = 1001;

    public static int n, m, idx;

    public static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], q = new int[N];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int[] movesToStamp(String stamp, String target) {
        // 1. 转换成字符数组方便调用s, t
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        // 2. 获取各自长度m,n
        int m = s.length;
        int n = t.length;
        // 3. 入度数组d初始化，
        Arrays.fill(d, m);
        // 填充入度数组为长度值。（相当于拓扑中的入度？）
        // 4. 队列初始化、图……算了在外面初始化得了
        idx = 1;
        Arrays.fill(h, -1);
        int r = 0, l = 0;
        // 5. for循环，[0, n-m]，载体是目标
        for (int i = 0; i <= n - m; i++) {
            // 	1. for循环，[0, m]，载体是印章
            for (int j = 0; j < m; j++) {
                // 		1. 如果印章字符和目标字符相等
                if (s[j] == t[i + j]) {
                    // 			入度--，如果为0，则入q;
                    if (--d[i] == 0) {
                        q[r++] = i;
                    }
                    // 		否则，入图，方向(i+j)->i;
                } else {
                    add(i + j, i);
                }
            }
        }

        // 6. 去重数组v
        // 7. 设置答案数组path
        // 8. while循环，topsort过程
        int size = 0;
        boolean[] vd = new boolean[n];
        int[] path = new int[n - m + 1];
        while (l < r) {
            int cur = q[l++];
            path[size++] = cur;
            for (int i = 0; i < m; i++) {
                if (!vd[cur + i]) {
                    vd[cur + i] = true;
                    for (int j = h[cur + i]; j != -1; j = ne[j]) {
                        if (--d[e[j]] == 0) {
                            q[r++] = e[j];
                        }
                    }
                }
            }
        }

        // 9. 判断：如果path长度不为n-m+1，返回空数组
        if (size != n - m + 1) {
            return new int[0];
        }

        // 10. 逆序调整path，输出！
        for (int i = 0, j = path.length - 1; i < j; i++, j--) {
            int tmp = path[i];
            path[i] = path[j];
            path[j] = tmp;
        }

        return path;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(movesToStamp("abca", "aabcaca")));
    }
}
