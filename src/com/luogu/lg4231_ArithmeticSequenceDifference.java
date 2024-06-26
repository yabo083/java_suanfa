package com.luogu;

import java.io.*;

/**
 * 等差数列差分
 *
 * 核心是在特定位置加减和两次前缀和操作，都能理解
 *
 * 嗯，似乎没了，问题在于，我怎么确定有效范围？
 * 这样，如果直接是在求完前缀和的数组上操作，那从1开始是有效值，至于到多少，那就得再看了
 *
 * @author Yabo
 * @date 2024/06/18
 */
public class lg4231_ArithmeticSequenceDifference {

    public static int MAXN = (int)1e7 + 5;

    public static long[] arr = new long[MAXN];

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
        // 2. 做出操作
        for (int i = 0, l, r, s, e; i < m; i ++) {
            l = sc.nextInt();
            r = sc.nextInt();
            s = sc.nextInt();
            e = sc.nextInt();
            set(l, r, s, e, (e-s)/(r-l));
        }
        // 3. 所有操作完成后，构建final
        build();
        // 4. 按要求计算最大值和异或值
        long max = 0, xor = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, arr[i]);
            xor ^= arr[i];
        }
        // 5. 输出
        sc.pw.println(xor + " " + max);
        sc.pw.flush();

    }

    public static void set(int l, int r, int s, int e, int d) {
        // 1. 在特定位置加减
        arr[l] += s;
        arr[l+1] += d - s;
        arr[r+1] -= d + e;
        arr[r+2] += e ;

    }

    public static void build() {
        // 1. 求两次前缀和
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i-1];
        }
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i-1];
        }
    }


}
