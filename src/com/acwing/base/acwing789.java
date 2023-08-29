package com.acwing.base;

import java.io.*;

public class acwing789 {

    static final int N = 100010;
    static int n, m;
    static int[] q = new int[N];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }

        while (m -- > 0){
            int x = sc.nextInt();

            int l = 0, r = n - 1;
            while (l < r){
                int mid = l + r >> 1;
                if (q[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (q[l] != x ) sc.write("-1 -1");
            else {
                sc.write(l);
                l = 0;
                r = n - 1;
                while (l < r){
                    int mid = l + r + 1 >> 1;
                    if (q[mid] <= x)  l = mid;
                    else r = mid - 1;
                }
                sc.write(l);
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
