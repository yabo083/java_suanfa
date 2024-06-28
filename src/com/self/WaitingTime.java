package com.self;

import java.util.PriorityQueue;

/**
 * 题意理解：<br />
 * 1. 欲求：等待时间——一个点<br />
 * 2. 扩展：[0, 效率最高，平均用时最短的服务员的服务时间*m个人]<br />
 * 0好说，m=0，你一来就有人，所以等候时间为0；<br />
 * 至于右端点，没什么起始逻辑，这是应该想到的。<br />
 * 一个比较合理的边界。<br />
 * 实际上的时间肯定比这短，因为其他服务员又不是摆设。<br />
 * 3. 判断：在当前时间下，能服务到w+1号客人吗？<br />
 * 能？继续缩短时间，我看看还能多短？史官史官？记这个！<br />
 * 不能？只能增加服务时间了。<br />
 * <hr>
 * 4. f函数：在当前时间下，能服务几名客人？<br />
 * （正在服务的客人，得算！）<br />
 * （刚结束一名客人，立刻就轮到你，这种情况也得算！）<br />
 * 算法：时间分别除以每个服务员的服务一人的时间再强制+1，<br />
 * 随后再一累加，即可。<br />
 * @author Yabo
 * @date 2024/06/28
 */
public class WaitingTime {

    public static int waitingTime2(int[] arr, int w) {
        // 1. 找到最小值，以便计算二分区间右端点
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
        }
        // 2. 创建答案变量
        int ans = 0;
        // 3. for循环二分
        for (int l = 0, r = min * w, m; l <= r; ) {
            m = l + ((r - l) >> 1);
            if (f(arr, m) >= w + 1) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // 4. 返回答案
        return ans;
    }

    public static int f(int[] arr, int time) {
        // 1. 时间分别除以每个服务员的服务一人的时间再强制+1，
        // 随后再一累加，即可。
        int sum = 0;
        for (int i : arr) {
            sum += (time / i) + 1;
        }
        return sum;
    }

    public static int waitingTime1(int[] arr, int m) {
        // 一个一个对象int[]
        // [醒来时间，服务一个客人要多久]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = arr.length;
        for (int j : arr) {
            heap.add(new int[]{0, j});
        }
        for (int i = 0; i < m; i++) {
            int[] cur = heap.poll();
            cur[0] += cur[1];
            heap.add(cur);
        }
        return heap.peek()[0];
    }

    // 对数器测试
    public static void main(String[] args) {
        System.out.println("测试开始");
        int N = 50;
        int V = 30;
        int M = 3000;
        int testTime = 20000;
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = randomArray(n, V);
            int m = (int) (Math.random() * M);
            int ans1 = waitingTime1(arr, m);
            int ans2 = waitingTime2(arr, m);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }

    // 对数器测试
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }


}
