//https://leetcode.cn/problems/reformat-phone-number/
//已对其进行常规验证与特殊验证，皆通过（借助debug与手工画图），初步理解。
package com.leetcode;


class ReformatPnoneNUmber {
    public static String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) sb.append("-");
            //以下是开始对 剩下4个元素的处理，挺妙的！
            if (i + 5 > n) {
                if (i + 3 >= n) sb.append(s.substring(i));//在距末尾第三或第二的位置，这样的情况直接截
                else sb.append(s.substring(i, i + 2)).append("-").append(s.substring(i + 2));//有四个元素剩下时，划分为有两个数字的块。
                break;
            }
            sb.append(s.substring(i, i + 3));//常规的三个数字一截
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("192-8888 99"));
    }
}
