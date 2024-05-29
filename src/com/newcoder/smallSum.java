package com.newcoder;

import java.io.*;

public class smallSum {

    public static int max = 100001, n;

    public static int[] arr = new int[max], help = new int[max];

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
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.pw.write(smallSumSort(0, n - 1) + "\n");
        sc.pw.flush();
    }

    private static long smallSumSort(int l, int r) {
        if (l == r)
            return 0;
        int m = l + ((r - l) >> 1);
        return smallSumSort(l, m) + smallSumSort(m + 1, r) + merge(l, m, r);

    }

    private static long merge(int l, int m, int r) {
        long ans = 0;
        int sum = 0;
        for (int i = l, j = m + 1; j <= r; j ++){
            while (i <= m && arr[i] <= arr[j]){
                sum += arr[i++];
            }
            ans += sum;
        }

        int a = l, i = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i ++] = arr[a] <= arr[b] ? arr[a ++] : arr[b ++];
        }

        while (a <= m){
            help[i ++] = arr[a ++];
        }

        while (b <= r){
            help[i ++] = arr[b ++];
        }

        for (i = l; i <= r; i ++){
            arr[i] = help[i];
        }
        return ans;
    }


}
