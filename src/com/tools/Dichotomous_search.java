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

    int right_bound(int l, int r) {
        while (l < r) {
            int mid = l + (r - l + 1) >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    int left_bound(int l, int r) {
        while (l < r) {
            int mid = l + (r - l) >> 1;
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
