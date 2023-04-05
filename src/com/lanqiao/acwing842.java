package com.lanqiao;

import java.io.*;

public class acwing842 {

    static int N = 10, n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.println(o);
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        dfs(0);
    }

    /**
     * 还是不太懂，主要是数字转移过程。但大体思想懂了
     * @param u 这是代表第几个数字，一共是n个数字
     */
    private static void dfs(int u) {

        //这是递归到最后一个数字时才执行的部分，其余时候可以不用管
        if (u == n) {
            for (int i = 0; i < n; i++)
                sc.write(path[i] + " ");
            return;
        }

        //这是主要的，
        for (int i = 1; i <= n; i++) {
            if (!st[i]){ //这是说没有被用过的数才可以用，似乎是将下标当数了。
                path[u] = i; //将这第“u”个数存为i
                st[i] = true; // 这下i被用了，置为ture，+1 进下一层喽！
                dfs(u + 1); // 进下一层
                st[i] = false; // 出来了，回溯了，现场要恢复了，才能不影响下一次深搜
                                //第一次的朴素注释完毕，
            }
        }
    }


}
