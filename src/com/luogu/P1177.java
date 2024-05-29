package com.luogu;

import java.io.*;

public class P1177 {

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

    public static int max = 100001, n;

    public static int[] arr = new int[max], help = new int[max];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        mergeSort1(0, n - 1);
//        mergeSort2();

        for (int i = 0; i < n; i++) {
            sc.pw.write(arr[i] + " ");
        }
        sc.pw.write("\n");
        sc.pw.flush();
    }

    private static void mergeSort1(int l, int r) {
        if (l == r)
            return;
        int m = l + ((r - l) >> 1);
        mergeSort1(l, m);
        mergeSort1(m + 1, r);
        merge(l, m, r);
    }


    public static void mergeSort2() {
        for (int l, m, r, step = 1; step < n; step ++){
            l = 0;
            while (l < n){
                m = l + step - 1;
                if (m + 1 >= n)
                    break;
                r = Math.min(n - 1, m + step);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    private static void merge(int l, int m, int r) {
        int a = l, i = l;
        int b = m + 1;
        while (a <= m && b <= r){
            help[i ++] = arr[a] <= arr[b] ? arr[a ++] : arr[b ++];
        }

        while (a <= m) help[i ++] = arr[a ++];
        while (b <= r) help[i ++] = arr[b ++];

        for (i = l; i <= r; i ++) arr[i] = help[i];

    }


}
