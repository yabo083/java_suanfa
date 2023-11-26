package com.competition.chaunzhi;

import java.io.*;
import java.util.Arrays;

public class redblue {


    public static int N = 100010, M = 200010;

    public static int n, m, idx;

    public static int[] h = new int[N], e = new int[M], ne = new int[M], color = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = n - 1;

        Arrays.fill(h, -1);

        while (m-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            add(a, b);
            add(b, a);
        }

        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            sc.write("Yes");
        } else {
            sc.write("No");
        }

        sc.pw.flush();
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;

        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c)) {
                    return false;
                }
            } else if (color[j] == c) {
                return false;
            }
//            会出现这种情况，在dfs过程中，在从某个点出发去染别的点时，可能会染到给自己染色的点，然后
//            因为师傅和徒弟之间用的颜色肯定不同，所以在徒弟回去盘问师傅时，不会走入第二个if。
//            硬要说，感觉像一种冗余情况。
//            else {
//                System.out.println("why come here?");
//            }
        }
        return true;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
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


