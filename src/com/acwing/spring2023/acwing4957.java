package com.acwing.spring2023;

import java.io.*;
import java.util.Arrays;

public class acwing4957 {

    static int N = 10;

    static int n;
    static Plane[] planes = new Plane[N]; //存储飞机的数组
    static boolean st[] = new boolean[N]; //标记当前飞机是否已经被安排过了的状态数组

    public static void main(String[] args) throws IOException {
        int T = sc.nextInt();
        while (T-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++)
                planes[i] = new Plane(sc.nextInt(), sc.nextInt(), sc.nextInt());

            Arrays.fill(st, false);
            if (dfs(0, 0))
                sc.write("YES");
            else
                sc.write("NO");

        }

    }

    private static boolean dfs(int u, int last) {   //u代表这次安排的是第u架飞机，last代表上一架飞机的降落时刻


        if (u == n) return true;                    //如果有幸所有飞机都安排完了，那么就返回就证明成功找到一种方案


        for (int i = 0; i < n; i++) {

            if (!st[i] && planes[i].t + planes[i].d >= last) {                      //这个if语句的意义是什么呢？如果当前飞机没有被安排过，且当前飞机的到达时刻+盘旋时间>=上一个飞机的降落时刻，那么就可以着手安排当前飞机
                                                                                    //什么意思呢？就是当前飞机盘旋完上一架飞机都还没降落，体现在时间上就是时间不够了等不及了，那就被if条件判false，跳过这架飞机，
                st[i] = true;//标记当前飞机已经被安排过了，和下面的成对使用
                if (dfs(u + 1, Math.max(last, planes[i].t) + planes[i].l)) //这里y总还是厉害，将原本写两遍的dfs浓缩成一个，十分简便。主要思想是
                                                                                    //主要就是理解这里的第二个参数的last代表什么，last代表上一架飞机的降落时刻。
                                                                                    //我们总是取时间线上靠后的那个时刻来作为当前飞机的开始降落时刻
                                                                                    //如果上一架飞机降落了，而且过了一段时间当前飞机才来，那当前飞机的真正降落时刻是planes[i].t+planes[i].l
                                                                                    //如果当前飞机在上一架飞机降落之前就来了搁天上等着，那么当前飞机的真正降落时刻是last+planes[i].l，就是你降落完我就紧接着降落

                    return true;                                                    //这里直接返回true也有门道，因为我们只要找一种方案就行了，所以不必在把所有的方案都找出来了。
                st[i] = false;//回溯，dfs标配
            }
        }


        return false;
    }

    static class Plane {
        int t, d, l;

        public Plane(int t, int d, int l) {
            this.t = t;//到达时刻
            this.d = d;//盘旋时间
            this.l = l;//降落时间
        }
    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.println(o);
            pw.flush();
        }


    }

}
