package com.tools;

public class Hex {

    /**
     * 将任意进制数转换为十进制数
     *
     * @param str 一个字符串数组，表示任意进制下的各个位数
     * @param b 进制
     * @return 转换后的十进制数
     */
    public static long hex(int[] str, int b) {
        long decimalValue = 0;
        for (int digitValue : str) {
            // 将每个位数转换为整数
            // 计算每个位数的值并将它们相加
            decimalValue = decimalValue * b + digitValue;
        }
        System.out.println(decimalValue);
        return decimalValue;

    }
}
