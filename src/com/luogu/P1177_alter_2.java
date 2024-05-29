package com.luogu;

import java.io.*;

public class P1177_alter_2 {

    public static int max = 100001, n;
    public static int[] arr = new int[max];

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        heapSort1();

        for (int i = 0; i < n; i++) {
            sc.pw.write(arr[i] + " ");
        }
        sc.pw.write("\n");
        sc.pw.flush();
    }

    public static void heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    private static void heapSort1() {
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }

    private static void heapSort2() {
        for (int i = n - 1; i >= 0; i--) {
            heapify(i, n);
        }
        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
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
