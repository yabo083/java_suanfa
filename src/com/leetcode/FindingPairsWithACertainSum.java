package com.leetcode;

import java.util.HashMap;

public class FindingPairsWithACertainSum {

    static class FindSumPairs {

        int[] nums2;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            for (int i : nums1) {
                map1.merge(i, 1, Integer::sum);
            }
            for (int j : nums2) {
                map2.merge(j, 1, Integer::sum);
            }
            this.nums2 = nums2;
        }

        public void add(int index, int val) {
            map2.merge(nums2[index], -1, Integer::sum);
            map2.merge(nums2[index] + val, 1, Integer::sum);
            nums2[index] += val;// 只运行一次不写没事，但如果第二次要加的正好是第一次加完的结果，可你没加，数组就没有，所以就错了。
        }

        public int count(int tot) {
            int counter = 0;
            for (Integer key : map1.keySet()) {
                int rv = tot - key;
                Integer count2 = map2.get(rv);
                if (count2 != null) {
                    counter += count2 * map1.get(key);
                }
            }
            return counter;
        }

        public int count2(int tot) {
            int rst = 0;
            for (int n : map1.keySet()) {
                rst += map2.getOrDefault(tot - n, 0) * map1.get(n);
            }
            return rst;
        }
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(findSumPairs.count(7));
        System.out.println(findSumPairs.count2(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count2(8));
        System.out.println(findSumPairs.count(4));
        System.out.println(findSumPairs.count2(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
        System.out.println(findSumPairs.count2(7));
    }

}
