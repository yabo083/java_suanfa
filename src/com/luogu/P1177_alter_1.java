package com.luogu;

import java.io.*;

public class P1177_alter_1 {


    public static int max = 100001, n;
    public static int[] arr = new int[max];
    public static int first, last;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            sc.pw.write(arr[i] + " ");
        }
        sc.pw.write("\n");
        sc.pw.flush();
    }

    public static void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }

        int x = arr[(int) (Math.random() * (r - l + 1)) + l];
        partition(l, r, x);
        int left = first, right = last;
        quickSort(l, left - 1);
        quickSort(right + 1, r);
    }

    public static void partition(int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                swap(i++, first++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(last--, i);
            }
        }
    }

    public static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
