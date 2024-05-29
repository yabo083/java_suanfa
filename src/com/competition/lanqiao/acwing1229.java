package com.competition.lanqiao;

import java.util.Scanner;


/**
 * <a href="https://www.acwing.com/problem/content/1231/">1229. 日期问题<a/>
 */
public class acwing1229 {

    //这里的第一个元素为0，就是为了使下标与月份对起。
    static int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

    static boolean check(int year, int month, int day){
        if (month == 0 || month > 12 || day == 0 )
            return false;
        //简单说下：当day大于月份的最大天数时，才是不合法的情况，小于是没事的
        if (month != 2 && day > days[month])
            return false;

        if (month == 2) {
            int leap = 0;
            if ((year % 100) != 0 && (year % 4) == 0 || year % 400 == 0)
                leap = 1;
            //此处同上，只不过优化了。
            return day <= (days[month] + leap);
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("/");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);

        for (int date = 19600101; date <= 20591231; date ++ ) {
            int year = date / 10000, month = date / 100 % 100, day = date % 100;
            int yearX =year % 100;
            if (check(year, month, day))
                if (yearX == a && month == b && day == c ||
                    month == a && day == b && yearX == c ||
                    day == a && month == b && yearX == c)
                    System.out.printf("%d-%02d-%02d\n", year, month, day);

        }

    }

}
