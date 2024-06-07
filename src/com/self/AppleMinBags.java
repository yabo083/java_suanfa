package com.self;

public class AppleMinBags {

    public static int bags1(int apple) {
        // 1. 调用子函数，用变量接受
        int ans = f(apple);
        // 2. 如果不是边界值，那就返回变量本身；如果是，那就返回-1
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int f(int rest) {
        // 1. 递归第一步：先做边界条件检查
        // 2. 如果剩余apple为负数，那么上一个袋子肯定没装满，不符合要求，直接返回设定的表示错误的值
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        // 3. 如果恰好等于0，那说明装完了，那这一次就不需要袋子了，所以直接返回0
        if (rest == 0) {
            return 0;
        }
        // 4. 接下来，就是递归过程，用8容量的袋子装剩下的苹果需要几个？用6容量的袋子装剩下的苹果需要几个？依次递归就行
        int p1 = f(rest - 8);
        int p2 = f(rest - 6);
        // 5. 随后再加上这一次的袋子，前提是有解可装，不能在无效解的时候再+对不对？
        p1 += p1 == Integer.MAX_VALUE ? 0 : 1;
        p2 += p2 == Integer.MAX_VALUE? 0 : 1;
        // 6. 最后返回使用的最少袋子数
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        for (int apple = 0; apple < 100; apple++) {
            System.out.println(apple + " : " + bags2(apple));
        }
    }

    public static int bags2(int apple) {
        if ((apple & 1) == 1) {
            return -1;
        } else if (apple < 18) {
            return apple == 0 ? 0 : apple == 6 || apple == 8 ? 1 : apple == 12 || apple == 14 || apple == 16 ? 2 : -1;
        } else {
            return (apple - 18) / 8 + 3;
        }
    }
}
