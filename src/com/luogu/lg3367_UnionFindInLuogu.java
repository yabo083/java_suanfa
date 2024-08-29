package com.luogu;

import java.io.*;

/**
 * 另一种模板，使用系统栈实现，编写起来更为简单<br />
 *
 * @author Yabo
 * @date 2024/08/29
 */
public class lg3367_UnionFindInLuogu {

    public static int MAXN = 10001;

    public static int[] father = new int[MAXN];

    public static int n;

    public static void build() {
        for (int i = 0; i <= n; i++) {
            father[i] = i;
        }
    }

    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i];
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        father[find(x)] = find(y);
    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        build();
        int m = sc.nextInt();
        for (int i = 0, op, x, y; i < m; i++) {
            op = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            if (op == 1) {
                union(x, y);
            } else {
                sc.write(isSameSet(x, y) ? "Y\n" : "N\n");
            }
        }
        sc.pw.flush();
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
