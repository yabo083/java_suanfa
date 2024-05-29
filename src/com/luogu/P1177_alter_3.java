package com.luogu;

import java.io.*;
import java.util.Arrays;

public class P1177_alter_3 {

    public static int max = 100001, BASE = 10, n;

    public static int[] arr = new int[max], help = new int[max], cnts = new int[BASE];

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

        sort();

        for (int i = 0; i < n; i++) {
            sc.pw.write(arr[i] + " ");
        }
        sc.pw.write("\n");
        sc.pw.flush();
    }

    private static void sort() {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < n; i++) {
            if (min > arr[i])
                min = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            if (max < arr[i])
                max = arr[i];
        }

        radixSort(bits(max));

        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }

    }

    private static void radixSort(int bits) {
        for (int offset = 1; bits > 0; offset *= BASE, bits --){
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[(arr[i] / offset) % BASE]++;
            }

            for (int i = 1; i < BASE; i++) {
                cnts[i] += cnts[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
            }

            System.arraycopy(help, 0, arr, 0, n);
        }
    }

    private static int bits(int number) {
        int ans = 0;
        while (number > 0){
            ans ++;
            number /= BASE;
        }
        return ans;
    }

}
