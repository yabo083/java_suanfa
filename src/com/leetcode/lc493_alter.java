package com.leetcode;

public class lc493_alter {

    public static int max = 50001, n;

    public static int[] help = new int[max];

    private static long counts(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;

        return counts(nums, l, m) + counts(nums, m + 1, r) + merge(nums, l, m, r);

    }

    private static long merge(int[] nums, int l, int m, int r) {
        long ans = 0;
        for (int i = m, j = r; i >= l; i--) {
            while (j >= m + 1) {
                if ((long)nums[i] > (long)nums[j]*2) {
                    ans += j - m;
                    break;
                } else {
                    j--;
                }
            }
        }

        int a = l, i = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = nums[a] <= nums[b] ? nums[a++] : nums[b++];
        }

        while (a <= m) {
            help[i++] = nums[a++];
        }

        while (b <= r) {
            help[i++] = nums[b++];
        }

        for (i = l; i <= r; i++) {
            nums[i] = help[i];
        }
        return ans;
    }

    public int reversePairs(int[] nums) {
        n = nums.length;
        int ans = (int) counts(nums, 0, n - 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        lc493_alter alter = new lc493_alter();
        System.out.println(alter.reversePairs(nums));
    }
}

