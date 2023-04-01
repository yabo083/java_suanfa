package com.lanqiao;

import java.io.*;

public class lq2020_1 {

    /**
     * 存储每个月的天数，0只起占位作用，2月先按28天来
     */
    static int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

    /**
     *检查是否是合法日期
     */
    static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;

        if ( month == 0 || month > 12 || day ==0) return false;
        if (month != 2 && day > days[month]) return false;
        if (month == 2) {
            int leap = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) leap = 1;
            return day <= 28 + leap;
        }
        return true;
    }

    /**
     * 读类
     */
    static class Read {

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

        //一个快写任何类型的方法
        public <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }

    }

    /**
     *检查是不是ABABBABA型回文日期
     */
    static boolean checkAB(int date){
        int a = date % 10;
        int b = date / 10 % 10;
        int[] ab = {a, b, a, b, b, a, b, a};
        for (int t = date, i = 7; t !=0; t /= 10, i -- ){
            int k = t % 10;
            if (ab[i] != k)
                return false;
        }
        return true;
    }


    /**
     *简单粗暴暴力循环
     */

    public static void main(String[] args) throws IOException{
        Read sc = new Read();

        int date = sc.nextInt();

        int res1 = -1;

        int res2 = -1;

        for (int i = 1000; i < 10000; i ++ ){
            int x = i, r = i;
            for (int j = 0; j < 4; j ++){
                r = r * 10 + x % 10;
                x /= 10;
            }
            if (date < r && check(r)){
                if (res1 != -1 && res2 != -1)
                    break;
                if (res1 == -1){
                    res1 = r;
                }
                if (res2 == -1 && checkAB(r)){
                    res2 = r;
                }
            }
        }

        sc.write(res1);
        sc.write(res2);

    }
}
