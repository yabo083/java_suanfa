package com.self;

public class IsSumOfConsecutiveNumbers {
    public static boolean is1(int num) {
        // 1. 依次枚举
        for (int i = 1; i < num; i ++ ) {
            int sum = i;
            for (int j = i + 1; j < num; j ++) {
                if (sum + j > num)
                    break;
                if (sum + j == num)
                    return true;
                sum += j;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        // 2. 批量计算
        for (int i = 1; i < 100; i++) {
            System.out.println(i + " : " + (is2(i) ? "T" : "F"));
        }
    }

    public static boolean is2(int num) {
        // 3. 寻找规律: 如果是二的幂就不行
        return (num & (num - 1)) != 0;

    }

}
