package com.lanqiao;

import java.io.*;
import java.util.Arrays;

public class acwing165 {

    static int N = 20, n, m, ans = N;

    static int[] car = new int[N];
    static Integer[] cat = new Integer[N];

    /**
     * 咱的函数参数语义与y总的不同，y总的也好，也理解了。
     * y总的k是代表假如有五辆车，那k就是5，但dfs(0, 0)，遍历时就只能稍微错开一点，for循环的只能写 < ,要开新车，直接car[k], 但dfs(u+1, k+1)的k+1是传的车数。总之不要把这k当成第几辆车，而是总车数，这也是题目要求的。
     * @param u u代表第u只猫猫
     * @param k k代表当前有k辆车，而且是全要用的;u和k都从1开始，从语义上更好理解。
     */
    static void dfs(int u, int k) {
        if (k >= ans) return; // 新的方案数用的车比原来多是吧？剪掉！

        if (u > n) { //u从1开始，那u 从n - 1来到n时，第n只猫猫还没有放，所以= 要改成 >
            ans = k;
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (car[i] + cat[u] <= m) {
                car[i] += cat[u];
                dfs(u + 1, k);
                car[i] -= cat[u];
            }
        }

        car[k + 1] = cat[u];  // 开一辆新的车装第u只猫猫
        dfs(u + 1, k + 1); // 以总共k+1辆车的状态，考虑第u+1只新猫猫
        car[k + 1] = 0;
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
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++)
            cat[i] = sc.nextInt();

        //将cat数组转换成Integer类型，降序排列
//        Integer[] cat2 = new Integer[n];
//        for (int i = 0; i < n; i ++){
//            cat2[i] = cat[i];
//        }
//        Arrays.sort(cat2, Collections.reverseOrder());
        Arrays.sort(cat, 1, n, (a, b) -> b - a);

        dfs(1, 1);

        sc.write(ans);


    }

}
