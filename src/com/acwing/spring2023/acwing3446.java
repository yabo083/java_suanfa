package com.acwing.spring2023;

import java.io.*;
import java.util.Arrays;

public class acwing3446 {

    //自己的做法
    /*
    //先录入数据，按%2 ？= 0来分类，分别存下来，再排序，再输出
    static ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();

    static int T = 10;

    public static void main(String[] args) throws IOException {
        while (T-- > 0) {
            int x = sc.nextInt();
            if (x % 2 == 0) {
                a.add(x);
            } else {
                b.add(x);
            }
        }
        a.sort((a, b) -> a - b);
        b.sort((a, b) -> b - a);
        b.forEach(a -> sc.write(a +" "));
        a.forEach(a -> sc.write(a +" "));
        sc.pw.flush();
    }*/

    static Integer[] w = new Integer[10];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(w, (a, b) -> {
            int ra = a % 2, rb = b % 2;         // ra = 0表示a是偶数，ra = 1表示a是奇数
            if (ra == rb) {                     // 如果a和b都是偶数或者都是奇数，那就按照大小排序
                if (ra == 0) {                  // 如果a和b都是偶数，那就按照升序排序
                    return a - b;
                } else {
                    return b - a;               // 如果a和b都是奇数，那就按照降序排序
                }
            } else {
                return rb - ra;                 // 如果a和b一个是偶数一个是奇数，那就把奇数排在前面
            }                                   // 具体是这样：如果 ra 和 rb 不相等，那么说明一个是奇数，一个是偶数。
                                                // 在这种情况下，返回 rb - ra。由于奇数的余数为 1，偶数的余数为 0，
                                                // 所以当 a 是奇数、b 是偶数时，返回值为负数；
                                                // 当 a 是偶数、b 是奇数时，返回值为正数。
                                                // 根据 Arrays.sort 方法的规则，返回负数意味着 a 在前、b 在后；返回正数意味着 b 在前、a 在后。
                                                // 因此，在这种情况下，奇数总是排在偶数前面。

        });
        Arrays.stream(w).forEach(a -> sc.write(a + " "));
        sc.pw.flush();
    }

    static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }

}
