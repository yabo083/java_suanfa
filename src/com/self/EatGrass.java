package com.self;

public class EatGrass {

    public static String win1(int n) {
        // 1. 直接返回调用的子函数
        return f(n, "A");
    }

    public static String f(int rest, String cur) {
        // 1. 确认对手
        String enemy = cur.equals("A") ? "B" : "A";
        // 2. 进行特判：在剩余艹小于5份的情况下，如果艹等于0或2，那么一定是对手赢，反之则是己方赢
        if (rest < 5) {
            return rest == 0 || rest == 2 ? enemy : cur;
        }
        // 3. 进行枚举，用while来作弊，需要尝试所有可能（1,4,16,……），一旦有我方胜利的时刻，就直接返回我方，不然……
        int p = 1;
        while (p < rest) {
            if (f(rest - p, enemy).equals(cur)) {
                return cur;
            }
            p *= 4;
        }
        return enemy;
    }

    public static String win2(int n) {
        // 1. 根据规律作答：5个为一组，第一个和第三个是对手赢，其余我方赢
        if (n % 5 == 0 || n % 5 == 2) {
            return "B";
        } else {
            return "A";
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(i + " : " + win2(i));
        }
    }

}
