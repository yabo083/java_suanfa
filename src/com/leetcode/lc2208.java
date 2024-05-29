package com.leetcode;

public class lc2208 {

    public static int max = 100001, size;

    public static long[] heap = new long[max];

    public static void heapify(int i) {
        int l = 2 * i + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;
            best = heap[best] > heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void heapInsert(int i) {
        size++;
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int i, int j) {
        long tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public static int halveArray(int[] nums) {
//        size = nums.length;

        long sum = 0;

//        for (int i = size - 1; i >= 0; i--) {
//            heap[i] = (long) nums[i] << 20;
//            sum += heap[i];
//            heapify(i);
//        }

        for (int i = 0; i < nums.length - 1; i ++){
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapInsert(i);
        }

        sum /= 2;
        int ans = 0;
        for (long minus = 0; minus < sum; ans++) {
            heap[0] /= 2;
            minus += heap[0];
//            System.out.println(minus);
            heapify(0);
        }

        return ans;

    }

    public static void main(String[] args) {
        // test halveArray method
        System.out.println(lc2208.halveArray(new int[]{5,19,8,1}));
    }
}
