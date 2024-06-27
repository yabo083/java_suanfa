package com.leetcode;

import java.util.Arrays;

/**
 * 题意理解：
 * <br>
 * 不是很会。
 * <hr>
 * 但是先排序，
 * <br>
 * 然后看看首尾配对能不能上船。
 * <br>
 * 不能就尾单独坐一船，解决一人；能就首尾两人坐一船，解决两人
 * <br>
 * 某些情况下会剩一个人，此时首尾指针全部指着他，这样一来不能将重量总和算两次，
 * <br>
 * 需单独考虑！
 *
 * @author Yabo
 * @date 2024/06/27
 */
class lc881_BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        // 1. 排序！
        Arrays.sort(people);
        // 2. 初始化一些变量：首尾指针、一个重量总和、答案变量
        int l = 0, r = people.length - 1, sum = 0, ans = 0;
        // 3. while循环，开始安排！
        while (l <= r) {
            //     1. 如果此时首尾指针指向两个人，则总和是两个人重量之和
            sum = l == r ? people[l] : people[l] + people[r];
            if (sum > limit) {
                //     2. 如果超限，则只能尾指针--，代表此次只能安排一人一船
                r--;
            } else {
                //     3. 如果未超限，则两个指针都--，代表此次达到了最好的结果，两人一船
                l++;
                r--;
            }
            //     4. 无论如何，使用船数++
            ans++;
        }
        // 4. 返回答案变量
        return ans;

    }
}
