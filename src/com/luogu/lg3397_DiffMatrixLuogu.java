package com.luogu;

import java.io.*;

public class lg3397_DiffMatrixLuogu {

    public static int MAXN = 1002;

    public static int[][] diff = new int[MAXN][MAXN];

    public static int n, m;

    public static void main(String[] args) throws IOException {
        // 1. 接收数据（一块地毯就是一次差分）
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0, a, b, c, d; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            // 2. 进行二维前缀和操作
            add(a, b, c, d, 1);
        }
        build();
        // 3. 输出结果
        for(int i = 1; i <=n; i ++) {
            sc.write(diff[i][1]);
            for (int j = 2; j <= n; j ++){
                sc.write(" " + diff[i][j]);
            }
            sc.write("\n");
        }
        sc.pw.flush();
        // 4. 清除，为下次调用做准备
        clear();
    }

    public static void add(int a, int b, int c, int d, int k) {
        // 1. 这是差分操作……我也能勉强解释
        diff[a][b] += k;
        diff[a][d + 1] -= k;
        diff[c + 1][b] -= k;
        diff[c + 1][d + 1] += k;
    }

    public static void build() {
        // 1. 二维前缀和，因为数组是咱们自己创造的，所以当然采用带0行和0列的，所以for循环要从1开始。
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
    }

    public static void clear() {
        // 1. 清理也从1开始，终止条件可以多清一点，但真的要必要？
        // 2. 还真有！因为通过模拟，发现被放置在边界的地毯在公式中只有左上角的值被利用到了，其他值都是摆设。
        // 3. 本质洞悉：只有左上角值是正向，而其他三个角的值只是某种约束。
        for (int i = 1; i <= n + 1; i++)
            for (int j = 1; j <= n + 1; j++)
                diff[i][j] = 0;
    }

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
}
