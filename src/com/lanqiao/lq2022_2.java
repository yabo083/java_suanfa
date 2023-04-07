package com.lanqiao;

import java.io.*;

public class lq2022_2 {

    static int N = 100010;

    static long[] s = new long[N];

    static int n, x;

    static boolean check(int m){
        for (int i = 1; i + m <= n; i ++)
            if (s[i + m - 1] - s[i - 1] < x) //这里同时减1是为了保证检测区间长度是3，画画图就知道了
                return false;
        return true;
    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        x = sc.nextInt();
        for (int i = 1; i < n; i ++){
            s[i] = s[i -1] + sc.nextInt();
        }

        x *= 2;

        int l = 1, r = n;
        while (l < r){
            int mid = (l + r) >> 1;
            if (check(mid)) r = mid; //说明够长，甚至超过了太多？
            else l = mid + 1;        //说明不够，mid也不够，需要加长
        }                            //以上指的都是跳跃长度
        sc.write(l);
    }



}
