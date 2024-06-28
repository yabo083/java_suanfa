package com.newcoder;

import java.io.*;

/**
 * 题意理解：
 * <br />
 * 能量不守恒，而是遵循特定规则<br />
 * 大于建筑，+差值<br />
 * 小于建筑，-差值<br />
 * <hr>
 * 1. 欲求：初始能量最小值——一个点<br />
 * 2. 扩展：[0, 建筑高度极大值]<br />
 * （能量无限大当然可以，但为了缩小讨论区间，<br />
 * 把它设为一个合理的边界也是有意义的。<br />
 * 当为建筑高度极大值时，机器人便可如履平地！）<br />
 * 3. 判断：当前高度能不能完成？<br />
 * 能？尝试更小的能量初值，同时记录答案，看看究竟能多小！<br />
 * 不能？只能给予更大的能量初值。<br />
 * <hr>
 * 4. f函数：当前高度能不能完成？<br />
 * 算法：从1到n，对能量进行加减运算，如果某次为负，返回false；<br />
 * 如果算完全程，返回true。<br />
 * 一个优化：如果能量滚雪球超过了最大值，直接开始如履平地！<br />
 * （也就直接返回true就好！）<br />
 *
 * @author Yabo
 * @date 2024/06/28
 */
public class RobotPassThroughBuilding {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        int rmax = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            rmax = Math.max(rmax, arr[i]);
        }
        sc.write(compute(1, rmax, rmax));
        sc.pw.flush();
    }

    public static int compute(int l, int r, int max) {
        int mid, ans = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (f(mid, max)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static boolean f(int energy, int max) {
        for (int i = 1; i <= n; i++) {
            if (arr[i] > energy) {
                energy -= arr[i] - energy;
            } else {
                energy += energy - arr[i];
            }
            if (energy < 0) {
                return false;
            }
            if (energy >= max) {
                return true;
            }
        }
        return true;
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
