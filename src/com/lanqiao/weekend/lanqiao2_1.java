package com.lanqiao.weekend;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class lanqiao2_1 {

    public static void main(String[] args) throws IOException {
        int T = scpro.nextInt();
        while (T-- > 0) {
            char[] arr = scpro.readLine().toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }

            long threeCount = map.values().stream().filter(c -> c == 3).count();
            long oneCount = map.values().stream().filter(c -> c == 1).count();

            if (threeCount == 1 && oneCount == 1) {
                scpro.write("Yes\n");
            } else {
                scpro.write("No\n");
            }
        }
        scpro.pw.flush();

    }

    public static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer，相比于readline读一行，这个方法可以读混合字符串和数字的一行而且只读取字符串。
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
            pw.print(o);
        }

    }

}

// 将值记录到一个hashmap中，然后遍历值集，如果发现不是由一个3和一个1组成的，就是错！
