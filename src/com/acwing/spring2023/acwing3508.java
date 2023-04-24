package com.acwing.spring2023;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 解决三个问题：
 * 1. 怎么区分所有子串？ ——提前算好字符串哈希前缀和，到时候通过区间和来区分是否是相同子串
 * 2. 怎么快速查找答案？ ——这时候我就要祭出二分法了
 * 3. 怎么处理数字？    ——将数字转换成不同字符就好，这样包含有数字的子串就算字母部分相同，也会因为数字转成的特殊字符不同而被排除
 */
public class acwing3508 {

    static int N = 20010, P = 131;

    static int n, m;

    static char[] str = new char[N];

    static long[] h = new long[N], p = new long[N];

    static HashSet <Long> set = new HashSet <>();

    static long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    static boolean check(int mid) {
        for (int i = 1; i + mid - 1 <= n; i++)
            set.add(get(i, i + mid - 1)); //找一下所有长度为mid的子串，并存到set中

        for (int j = n + 1; j + mid - 1 <= m + n; j++) {
            if (set.contains(get(j, j + mid - 1))) // 然后看看在另一个串中能不能找到
                return true;                          //找到就是true，返回给二分就成功缩小了范围！ok差不多了
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        String s1 = sc.readLine();
        String s2 = sc.readLine();
        n = s1.length();
        m = s2.length();
        s1.getChars(0, n, str, 1);
        s2.getChars(0, m, str, n + 1);          //以上就是把读进来的两个字符串放到一个数组中，方便处理

        p[0] = 1;
        for (int i = 1; i <= n + m; i++) {
            p[i] = p[i - 1] * P;
            char c = str[i];
            if (Character.isDigit(c)) {                           //对数字进行转换，解决了夹杂在字符串中数字的数字问题
                if (i <= n) {
                    c = '#';
                } else {
                    c = '$';
                }
            }
            h[i] = h[i - 1] * P + c;

        }

        int l = 0, r = Math.min(n, m);//最长公共子串肯定比较小的还小

        while (l < r) {                                          //二分法找最长，因为有二段性，将最长假定为ans，
            int mid = (l + r + 1) >> 1;                          //小于ans的子串都可以找到，大于ans的都找不到
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        sc.write(l);

    }

    static class sc {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        sc() throws IOException {
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


    }


}
