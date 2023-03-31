package com.lanqiao;

import java.io.*;
import java.util.Scanner;

public class acwing499 {

    public static class Read {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public long nextLong() throws IOException {
            st.nextToken();
            return (long) st.nval;
        }

        //只能读取纯字符串的方法
        public String readLine() throws IOException {    //	不推荐使用
            st.nextToken();
            return st.sval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public void write(Object o) {
            pw.println(o);
            pw.flush();
        }


    }

    static int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

    static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;

        if ( month == 0 || month > 12 || day ==0) return false;
        if (month != 2 && day > days[month]) return false;
        if (month == 2) {
            int leap = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) leap = 1;
            if (day > 28 + leap) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        Read sc = new Read();
        int date1 = sc.nextInt();
        int date2 = sc.nextInt();
        int res = 0;
        for (int i = 1000; i < 10000; i ++){
            int x = i, r = i;
            for (int j = 0; j < 4; j ++){
                r = r * 10 + x % 10;
                x /= 10;
            }
            if (r >=date1 && r <= date2 && check(r))
                res ++;
        }
//        System.out.println(res);
        sc.write(res);


    }


}
