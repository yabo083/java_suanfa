package com.acwing.base;


import java.io.*;

public class acwing786 {


    static int N = 100010;
    static int[] q = new int[N];
    static int n, k;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i ++) q[i] = sc.nextInt();
        sc.write(quick_sort(0, n - 1, k - 1));
        sc.pw.flush();

    }

    public static int quick_sort(int l, int r, int k) {
        if (l >= r) {
            return q[l];
        }

        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while (i < j) {
            while (q[++i] < x)
                ;
            while (q[--j] > x)
                ;
            if (i < j) {
                q[i] = q[i] ^ q[j];
                q[j] = q[j] ^ q[i];
                q[i] = q[i] ^ q[j];
            }
        }
        if (k <= j) {
            return quick_sort(l, j, k);
        } else {
            return quick_sort(j + 1, r, k);
        }

    }

    static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
            pw.flush();
        }


    }
}

