package com.leetcode;

class lc1438_LongestSubarrayAbsoluteLimit {

    public static int MAXN = 100001;

    // 窗口内最大值的更新结构（单调队列）
    public static int[] maxDeque = new int[MAXN];

    // 窗口内最小值的更新结构（单调队列）
    public static int[] minDeque = new int[MAXN];

    public static int maxh, maxt, minh, mint;

    public static int[] arr;

    // 判断如果加入数字number，窗口最大值 - 窗口最小值是否依然 <= limit
    // 依然 <= limit，返回true
    // 不再 <= limit，返回false
    public static boolean ok(int limit, int number) {
        // max : 如果number进来，新窗口的最大值
        int max = maxh < maxt ? Math.max(arr[maxDeque[maxh]], number) : number;
        // min : 如果number进来，新窗口的最小值
        int min = minh < mint ? Math.min(arr[minDeque[minh]], number) : number;
        return max - min <= limit;
    }

    // r位置的数字进入窗口，修改窗口内最大值的更新结构、修改窗口内最小值的更新结构
    public static void push(int r) {
        while (maxh < maxt && arr[maxDeque[maxt - 1]] <= arr[r]) {
            maxt--;
        }
        maxDeque[maxt++] = r;
        while (minh < mint && arr[minDeque[mint - 1]] >= arr[r]) {
            mint--;
        }
        minDeque[mint++] = r;
    }

    // 窗口要吐出l位置的数了！检查过期！
    public static void pop(int l) {
        if (maxh < maxt && maxDeque[maxh] == l) {
            maxh++;
        }
        if (minh < mint && minDeque[minh] == l) {
            minh++;
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        // 1. 初始化两个结构所用的指针
        maxh = maxt = minh = mint = 0;
        // 2. 数组复制
        arr = nums;
        // 3. 获取长度
        int n = arr.length;
        // 4. 设置答案变量
        int ans = 0;
        // 5. for循环，结束后就可获取答案
        for (int l = 0, r = 0; l < n; l++) {
            //     1. 初始化你脑子里的窗口中的两个指针，在l没有大于等于n之前，你永远不要结束循环。
            //     2. while循环，当r位置的数不会让任意两数之差超限时（哦老天这不就是最大值和最小值之差嘛
            //     允许之后我用这个代替），push这个r，让变化真正发生！如果会，那就结束while循环。
            while (r < n && ok(limit, arr[r])) {
                push(r++);
            }
            //     3. 显然，r代表此时你脑子里的虚拟窗口的最远右端点，当它无法被push进去，那就告诉我们，
            //     这个窗口的长度增长也就到此为止了，好了，来计算吧。
            //     4. max求最值，由于设定这个窗口是[,),表示的，所以方便不少。
            ans = Math.max(ans, r - l);
            //     5. 最后，把l点的数pop出去，我们总归是要探索下一个窗口的。
            pop(l);
        }
        // 6. 输出答案
        return ans;
    }


}
