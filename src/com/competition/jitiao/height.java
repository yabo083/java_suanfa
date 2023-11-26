package com.competition.jitiao;

import java.io.*;
import java.util.StringTokenizer;

public class height {

    public static int n;

    public static String[] names = new String[100];
    public static String[] heights = new String[100];
    public static Person[] persons = new Person[100];

    public static void main(String[] args) throws IOException {
        n = scpro.nextInt();
        names = scpro.readLine().split(" ");
        heights = scpro.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            persons[i] = new Person(Integer.parseInt(heights[i]), names[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 -i; j++) {
                if (persons[j].height < persons[j + 1].height) {
                    Person t = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = t;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            // 以[孙七,张三,李四,赵六,王五]这种格式输出
            if (i == 0) {
                scpro.write("[" + persons[i].name + ",");
            } else if (i == n - 1) {
                scpro.write(persons[i].name + "]");
            } else {
                scpro.write(persons[i].name + ",");
            }
        }
        scpro.pw.flush();
    }

    public static class Person {

        int height;
        String name;


        public Person(int height, String name) {
            this.height = height;
            this.name = name;

        }
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
