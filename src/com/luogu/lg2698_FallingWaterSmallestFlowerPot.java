package com.luogu;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 单调队列一达到两个，我这初次接触的脑子还分不清什么时候对应的结构要用对应的参数。
 * 注意这个问题
 */
public class lg2698_FallingWaterSmallestFlowerPot {

    public static int MAXN = 100005;

    public static int[][] arr = new int[MAXN][2];

    public static int n, d;

    public static int[] maxDeque = new int[MAXN];

    public static int[] minDeque = new int[MAXN];

    public static int maxh, maxt, minh, mint;

    public static void main(String[] args) throws IOException {
        // 1. 获取n、d
        n = sc.nextInt();
        d = sc.nextInt();
        // 2. 循环接收所有水滴
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        // 3. 调用计算答案
        int ans = compute();
        // 4. 输出答案
        sc.write(ans == Integer.MAX_VALUE ? -1 : ans);
        sc.pw.flush();
    }

    public static int compute() {
        // 1. 水滴数组排序，按横坐标谁小谁在前
        Arrays.sort(arr, 0, n, Comparator.comparingInt(a -> a[0]));
        // 2. 单调队列结构指针初始化
        maxh = maxt = minh = mint = 0;
        // 3. 设置答案变量
        int ans = Integer.MAX_VALUE;
        // 4. for循环，结束后就求出了最小的盆宽度，
        // 可使第一滴水与最后一滴水的滴落时间差大于D。
        for (int l = 0, r = 0; l < n; l++) {
            //     1. 初始化你脑子里应该有的一个虚拟窗口，l和r都从0开始
            //     2. while循环，当r这个水滴打破了限制，此时无论r小不小于n，
            //     都直接中断跳出循环。
            while (!ok() && r < n) {
                push(r++);
            }
            //     3. 如果此时盆的接水时间差大于了D，这也正是退出while循环的原因，
            //     就更新ans。r - 1 的雨滴，即暗示盆已合格
            if (ok()) {
                ans = Math.min(ans, arr[r - 1][0] - arr[l][0]);
            }
            //     4. 弹出l，向右探索。
            pop(l);
        }
        // 5. 返回答案
        return ans;

    }

    public static boolean ok() {
        // 1. 从单调队列获取最大值、最小值。
        // TODO: 为什么这题不能写成上一题lc1438的那种形式？
        int max = maxh < maxt ? arr[maxDeque[maxh]][1] : 0;
        int min = minh < mint ? arr[minDeque[minh]][1] : 0;
        // 2. 返回最大值和最小值之差与限制d的逻辑结果。
        return max - min >= d;
    }

    public static void push(int r) {
        // 1. 经典更新处理。
        while (maxh < maxt && arr[maxDeque[maxt - 1]][1] <= arr[r][1]) {
            maxt--;
        }
        maxDeque[maxt++] = r;
        while (minh < mint && arr[minDeque[mint - 1]][1] >= arr[r][1]) {
            mint--;
        }
        minDeque[mint++] = r;
    }

    public static void pop(int l) {
        // 1. 过期处理
        if (maxh < maxt && maxDeque[maxh] == l) {
            maxh++;
        }
        if (minh < mint && minDeque[minh] == l) {
            minh++;
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
