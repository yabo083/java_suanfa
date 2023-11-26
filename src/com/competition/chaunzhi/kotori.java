package com.competition.chaunzhi;

import java.io.*;

public class kotori {

    public static int N = 11;

    public static int n;

    public static int[] x = new int[N];

    public static int[][] a = new int[N][N];


    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++)
            devide(x[i], i);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int min = 0x3f3f3f3f;
            for (int j = 0; j < n; j++) {
                if (a[j][i] == 0)
                    continue;
                min = Math.min(min, a[j][i]);
                res += min;
            }
        }

        sc.write(res);
        sc.pw.flush();
    }

    private static void devide(int x, int l) {
        int cnt = 0;
        for (int i = 2; i <= x / i; i ++){
            if (x % i == 0){
                int s = 0;
                while (x % i == 0){
                    x /= i;
                    s ++;
                }
                a[l][cnt++] = i;
            }
            if ( x > 1)
                a[l][cnt++] = x;
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
