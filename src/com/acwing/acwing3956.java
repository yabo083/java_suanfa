package com.acwing;

import java.util.Scanner;

public class acwing3956 {

    public static void main(String[] args) {
        int N = 100010;
        int[] a = new int[N];

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            // 这个地方生成了前缀和数组，a[i]表示前i个数的和
            a[i] = a[i - 1] + in.nextInt();
        }

        if(a[n] % 3 != 0) {
            System.out.println(0);
        }
        else {
            long res = 0, cnt = 0;
            for (int j = 2; j < n ; j++) {
                // 这个地方是找到前缀和数组中，和为a[n]/3的数的个数，当找到的时候，就意味着找到了一个符合条件的子数组，
                // 即这第i个位置所代表的前i个数的和为a[n]的三分之一，而这是肯定的，一定会有的，所以此时将这种方案的个数加1
                if (a[j - 1] == a[n] / 3) {
                    cnt++;
                }
                // 而这个地方则是在枚举，俗话说的一个一个试。前面那个之所以在j++之后不必再从头开始找，是因为是否等于a[n]/3是一个相对固定的条件，
                // 既然在前缀和数组中第j-1个位置的值不为a[n]/3，那么在第j-2个位置的值也不可能为a[n]/3，所以不必再从头开始找，直接从第j个位置开始找就行了
                // 这就是前缀和的好处，然后再去判断这第二个区间+第一个区间的和是否为a[n]/3的二倍，如果是的话，就意味着找到一种方案，那就将此时的cnt加入到res中
                // 就行了
                if (a[j] == (a[n] / 3) * 2) {
                    res += cnt;
                }
            }
            System.out.println(res);
        }


    }

}
