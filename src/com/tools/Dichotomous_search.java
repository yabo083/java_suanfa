package com.tools;

/**
 * 二分查找
 * <a href="https://blog.csdn.net/raelum/article/details/128687109">y总版
 * <a href="https://blog.csdn.net/WJPnb1/article/details/126360962?spm=1001.2014.3001.5502">新版
 */
public class Dichotomous_search {

    private boolean check(int mid) {
        return true;
    }

    /**
     *那这个二分板子就是求最右满足条件的点喽
     * 【1，2，3，4，4，5】拿这个试一试就知道了。
     */
    int right_bound(int l, int r) {
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1); // 感觉这里还是得加括号提前算啊，要不然遇到极端清况不就寄了？
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    /**
     * 这确实是求最左的满足条件的点的下标的
     */
    int left_bound(int l, int r) {
        while (l < r) {
            int mid = l + ((r - l) >> 1); // 修改理由同上
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    int br_search(int n) {
        int l = -1, r = n;
        while (l + 1 != r) {
            int mid = l + (r - l) >> 1;
            if (check(mid)) l = mid;
            else r = mid;
        }
        return l; //or r;
        // 最后根据你所分左右两边区间的结果
        //选取L或者R作为结果
    }


}
