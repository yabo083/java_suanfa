package com.newcoder;

import java.io.*;

/**
 * 单调栈<br />
 * <hr>
 * 题型理解：<br />
 * 1. 分阶段处理：<br />
 * 遍历阶段：特征结构：while循环：弹出时机：<br />
 * 看到底是升序单调栈还是降序单调栈，<br />
 * 升序找两边最近的极小值，<br />
 * 降序找两边最近的极大值。<br />
 * 而且无论如何，新数据都要入栈，<br />
 * 这么看来，while循环只是个维护单调性的手段。<br />
 * <hr>
 * 2. 清算阶段（处理那些剩下的）<br />
 * 基本都是些特殊值，<br />
 * 没有右值的家伙。<br />
 * <hr>
 * 3. 修正阶段（可能有）<br />
 * 左边的答案一般 不需要修正，<br />
 * 起码确实是过了一遍栈，压在了小于自己或大于自己的数，记上了，才出来的，<br />
 * 右边就可能有问题了：<br />
 * 因为等于也要弹的设置，<br />
 * 所以可能会出现一个数的右极小值与本身相等的现象，<br />
 * 但这个时候我们可以用右极小值的右极小值来代替就可以了，<br />
 * 之所以可以这样，是因为从头到尾栈里和答案要求都是数组下标，而不是实际值。<br />
 *
 * @author Yabo
 * @date 2024/07/02
 */
public class LeftRightLess {

    public static int MAXN = (int) 1e6 + 1;

    public static int[] arr = new int[MAXN];

    public static int[] stack = new int[MAXN];

    public static int[][] ans = new int[MAXN][2];

    public static int n, r;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        compute();
        for (int i = 0; i < n; i++) {
            sc.write(ans[i][0] + " " + ans[i][1] + "\n");
        }
        sc.pw.flush();
    }

    public static void compute() {
        r = 0;
        int top;
        for (int i = 0; i < n; i++) {
            while (r > 0 && arr[i] <= arr[stack[r - 1]]) {
                top = stack[--r];
                ans[top][0] = r == 0 ? -1 : stack[r - 1];
                ans[top][1] = i;
            }
            stack[r++] = i;
        }

        while (r > 0) {
            top = stack[--r];
            ans[top][0] = r == 0 ? -1 : stack[r - 1];
            ans[top][1] = -1;
        }

        for (int i = n - 2; i >= 0; i --){
            if (ans[i][1] != -1 && arr[ans[i][1]] == arr[i])
                // ans数组的下标和arr数组的下标是一一对应的，所以可以互用
                ans[i][1] = ans[ans[i][1]][1];
        }
    }

    public static class sc {

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
