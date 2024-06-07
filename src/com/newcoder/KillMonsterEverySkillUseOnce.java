package com.newcoder;

import java.io.*;

public class KillMonsterEverySkillUseOnce {

    public static int[] OD = new int[11];
    public static int[] Blood = new int[11];
    public static int N, n, m;


    public static void main(String[] args) throws IOException {
        // 1. 录入数据
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                OD[j] = sc.nextInt();
                Blood[j] = sc.nextInt();
            }
            // 2. 调用子函数计算
            int ans = f(n, 0, m);
            sc.pw.write(ans == Integer.MAX_VALUE ? -1 + "\n" : ans + "\n");

        }
        // 3. 输出
        sc.pw.flush();
    }

    public static int f(int n, int i, int r) {
        // 1. r是血条，如果它空了，那就返回魔法卷轴使用数
        if (r <= 0)
            return i;
        // 2. 如果技能使用数来到了n，也就是魔法卷轴的总数，那就寄了
        if (i == n)
            return Integer.MAX_VALUE;
        // 3. 一个计数器，需要初始化为最大值，否则只会返回0（意味着即死，不需要技能）
        int ans = Integer.MAX_VALUE;
        // 4. for循环，使用递归，目的是做一个全排列，根据卷轴总数比较小这个情况来的。
        for (int j = i; j < n; j ++){ //
            swap(i, j);
            ans = Math.min(ans, f(n, i + 1, r - (r > Blood[i] ? OD[i] : OD[i] * 2 )));
            swap(i, j);
        }
        // 5. 返回计数器
        return ans;
    }

    public static void swap(int i, int j) {
        // 1. 虽然是简单的交换函数，但记得同时要交换两个数组，技能普伤和倍伤都得跟着交换。
        int tmp = OD[i];
        OD[i] = OD[j];
        OD[j] = tmp;
        tmp = Blood[i];
        Blood[i] = Blood[j];
        Blood[j] = tmp;
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
