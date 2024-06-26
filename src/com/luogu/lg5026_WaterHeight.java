package com.luogu;

import java.io.*;

/**
 * 比较复杂，物理学不存在的一道题，
 * <br>
 * 核心在经过左神讲述后，反而不难，我比较拿不准的地方在于他为了不想讨论负数，
 * 而引入的偏移量而导致的
 * 1. 有效范围在哪？
 * 的问题
 *
 * @author Yabo
 * @date 2024/06/18
 */
public class lg5026_WaterHeight {
    public static int MAXN = (int)1e6 + 1;

    public static int OFFSET = 30001;

    public static int[] arr = new int[OFFSET + MAXN + OFFSET];

    public static int n, m;

    public static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }

    public static void main(String[] args) throws IOException {
        // 1. 接收数据
        n = sc.nextInt();
        m = sc.nextInt();
        // 2. 调用子函数1处理
        for (int i = 0, v, x; i < n; i++) {
            v = sc.nextInt();
            x = sc.nextInt();
            fall(v, x);
        }
        // 3. 调用子函数2处理
        build();
        // 4. 打印答案
        int s = OFFSET + 1;
        sc.write(arr[s++]);
        for (int i = 2; i <= m; i++) {
            sc.write(" " + arr[s++]);
        }
        sc.pw.flush();
    }

    public static void fall(int v, int x) {
        // 1. 对于一次落水，我们要操作四次，那就不妨来个子函数
        // 2. 四个等差数列，注意首尾不重合
        set(x - 3 * v + 1, x - 2 * v, 1, v, 1);
        set(x - 2 * v + 1, x, v - 1, -v, -1);
        set(x + 1, x + 2 * v, -v + 1, v, 1);
        set(x + 2 * v + 1, x + 3 * v - 1, v - 1, 1, -1);
    }

    public static void set(int l, int r, int s, int e, int d) {
        // 1. 三加一减，+s，+d-s，-(e+d), +e
        arr[l + OFFSET] += s;
        arr[l + 1 + OFFSET] += d - s;
        arr[r + 1 + OFFSET] -= e + d;
        arr[r + 2 + OFFSET] += e;
    }

    public static void build() {
        // 1. 两次前缀和，尝试优化一下？
        // 没法化简，在极端情况下，arr的最左端可能被用到，为了通用，只能放弃优化
        for (int i = 1 ; i <= m + OFFSET; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1 ; i <= m + OFFSET; i++) {
            arr[i] += arr[i - 1];
        }
    }

}
