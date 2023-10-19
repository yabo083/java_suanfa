package com.acwing.base;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class acwing894 {

    public static int N = 110;

    public static int n;
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        Arrays.fill(f, -1);
        int res = 0;
        while (n-- > 0) {
            int x = sc.nextInt();
            res ^= sg(x);
        }

        if ((res & 1) == 1) {
            sc.write("Yes");
        } else {
            sc.write("No");
        }
        sc.pw.flush();
    }

    private static int sg(int x) {

        if (f[x] != -1) {
            return f[x];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                set.add(sg(i) ^ sg(j));
            }
        }

        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return f[x] = i;
            }
        }
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
