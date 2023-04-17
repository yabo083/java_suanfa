package com.acwing.spring2023;

import java.io.*;


public class acwing4958 {

    static int N = 100010;

    static int n, num;
    static int[] g = new int[10]; //g[i]表示以i结尾的接龙数列的长度的最大值，为什么是10呢，因为结尾的数字只有0-9...

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        int res = 0;

        for (int i = 0; i < n; i++) {

            num = sc.nextInt();                        //像以下四行一样处理，更快一点
            int r = num % 10;
            while(num >= 10) num /= 10;
            int l = num;

            int f = Math.max(1, g[l] + 1);             //那现在f就表示以r结尾的接龙数列的长度(注意这里的长度是从可以与它接龙的数列继承过来的，接头暗号就是g[l],对g[]而言，g[l]代表以l结尾的接龙数列的长度的最大值，对当前第i个数而言，l就是它的首数，然后你再想想？)
            g[r] = Math.max(g[r], f);                  //既然你上面求了f，那就趁此更新下以第i个数的r结尾的接龙数列的长度，以保证最新！
            res = Math.max(res, f);                    //动态求最值，与主逻辑没太大关系
        }
        sc.write(n - res);                         //体现对题意的巧妙理解：将最少删几个数，转换成了n - 最长接龙数列的长度，
    }                                                 //这里才恍然大悟，原来我们是在求最长接龙数列的长度。

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
