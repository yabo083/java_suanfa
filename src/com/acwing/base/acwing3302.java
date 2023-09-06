package com.acwing.base;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class acwing3302 {

    // 双栈
    public static Deque<Integer> num = new ArrayDeque<>();
    public static Deque<Character> op = new ArrayDeque<>();

    // 优先级表
    public static HashMap<Character, Integer> pr = new HashMap<>();

    static {
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);
    }

    public static void main(String[] args) throws IOException {
        // 读入表达式
        String str = scpro.readLine();
        // 从前往后扫描表达式
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 扫描到数字，使用双指针法一直读入
            if (Character.isDigit(c)) {
                // j表示扫描到数字的指针
                int x = 0, j = i;
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    x = x * 10 + str.charAt(j++) - '0';
                }
                // 更新i指针
                i = j - 1;
                // 数字入栈
                num.push(x);
            }
            // 左括号直接入栈
            else if ('(' == c) {
                op.push(c);
            }
            // 右括号出现，从右往左计算栈中数据，直到遇见左括号
            else if (')' == c) {
                // 不断使用eval函数对末尾数字运算
                //noinspection DataFlowIssue
                while ('(' != op.peek()) {
                    eval(num, op);
                }
                // 弹出左括号
                op.pop();
            }
            // 扫描到运算符
            else {
                // 如果栈顶运算符优先级较高，先操作栈顶元素再入栈
                while (!op.isEmpty() && op.peek() != '(' && pr.get(op.peek()) >= pr.get(c)) {
                    eval(num, op);
                }
                // 如果栈顶运算符优先级较低，直接入栈
                op.push(c);
            }
        }
        // 把没有操作完的运算符从右往左操作一遍
        while (!op.isEmpty()) {
            eval(num, op);
        }
        // 栈顶元素为最终答案
        System.out.println(num.peek());
    }

    // 求值函数，使用末尾的运算符操作末尾的两个数
    public static void eval(Deque<Integer> num, Deque<Character> op) {
        // 第二个操作数
        int b = num.pop();
        // 第一个操作数
        int a = num.pop();
        // 运算符
        char c = op.pop();

        // 结果计算（注意顺序）
        int x;
        if ('+' == c) {
            x = a + b;
        } else if ('-' == c) {
            x = a - b;
        } else if ('*' == c) {
            x = a * b;
        } else {
            x = a / b;
        }
        // 结果入栈
        num.push(x);
    }

    static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
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
        }

        //用来判断是否有未读取的数据
        static boolean hasNext() throws IOException {
            return br.ready();
        }


    }
}
