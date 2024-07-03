package com.newcoder;

import java.io.*;

/**
 * 题意理解：<br />
 * 大鱼吃小鱼<br />
 * 不知为何，只能大左吃小右，<br />
 * 还能同一轮吃！<br />
 * <hr>
 * 取max，是行动能并行的写照，<br />
 * 吃一条鱼花费一轮，那轮数就是某条鱼吃完所有能吃的所花费的轮数，<br />
 * 即使它中途被更大的鱼所吃，那那条鱼也得花费相同的轮数完成同样的捕食行动！<br />
 * <hr>
 * 单调栈在此处的意义是根据体重来计算、决定每条鱼可以行动的轮数。<br />
 * <hr>
 * 我们最后就是要一个多少轮之后鱼的数量不会变，<br />
 * 一般在可以行动的轮数最多的那条鱼行动完后就是了，<br />
 * 所以要一个轮数的最大值。<br />
 *
 * @author Yabo
 * @date 2024/07/03
 */
public class BigFishEatSmallFish {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static int[][] stack = new int[MAXN][2];

    public static int r;

    public static void main(String[] args) throws IOException {
        // 1. 接受数据
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 2. 调用子函数
        sc.write(turns());
        // 3. 返回答案
        sc.pw.flush();
    }

    public static int turns() {
        // 1. 初始化栈顶指针
        r = 0;
        // 2. 初始化答案变量
        int ans = 0;
        // 3. for循环，利用单调栈来确定每条鱼的行动次数，并寻找最大值。
        for (int i = n - 1, curTurns; i >= 0; i--) {
            curTurns = 0;
            while (r > 0 && stack[r - 1][0] < arr[i]) {
                curTurns = Math.max(curTurns + 1, stack[--r][1]);
            }
            stack[r][0] = arr[i];
            stack[r++][1] = curTurns;
            ans = Math.max(ans, curTurns);
        }
        // 4. 返回答案。
        return ans;

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
