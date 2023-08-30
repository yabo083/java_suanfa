package com.acwing.base;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;

public class acwing790 {

    public static void main(String[] args) throws IOException {
        double x = scPro.nextDouble();
        double l = -22, r = 22;
        while (r - l > 1e-8){
            double mid  = (l + r) / 2;
            if (mid * mid *mid >= x ) r = mid;
            else l = mid;
        }
        System.out.printf("%.6f\n",l);
    }

    static class scPro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scPro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer
        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数
        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }

        //输出指定小数位数的数值
        public static <T> void write(T o, int n) {
            if (o instanceof Double) {
                StringBuilder pattern = new StringBuilder("0.");
                for (int i = 0; i < n; i++) {
                    pattern.append("0");
                }
                DecimalFormat df = new DecimalFormat(pattern.toString());
                String formattedNumber = df.format(o);
                pw.print(formattedNumber);
            } else {
                pw.print(o);
            }
        }


        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }



    }

}
