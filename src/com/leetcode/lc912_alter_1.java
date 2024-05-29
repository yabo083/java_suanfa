package com.leetcode;

import java.io.*;

public class lc912_alter_1 {

    public static int n;

    public int[] sortArray(int[] nums) {
        n = nums.length;
        return heapSort2(nums);
    }

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l + 1] > arr[l] ? l + 1 : l;
            best = arr[best] > arr[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(arr,i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    private static void heapSort1(int[] arr) {
        for (int i = 0; i < n; i++) {
            heapInsert(arr, i);
        }
        int size = n;
        while (size > 1) {
            swap(arr,0, --size);
            heapify(arr,0, size);
        }
    }

    private static int[] heapSort2(int[] arr) {
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int size = n;
        while (size > 1) {
            swap(arr,0, --size);
            heapify(arr,0, size);
        }
        return arr;
    }


    public static void swap(int[] arr,int i, int j) {
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
