package com.newcoder;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 返回无序数组中累加和为给定值的最长子数组长度
 * <p>
 * 用的是前缀和的办法，一句话讲明：
 * <p>
 * 既然是给定值嘛，所以必定有个统计区间之和的过程， 不妨使用前缀和，而它有个特点，和与下标,也就距离、长度这种概念是对应的！
 * 那配以步进指针，减去给定值，相当于回看了一定的距离，而这其中越过的下标可不一定，那如何使其越过最多，离此时的步进指针最远呢？ 那这样问题就转换成了如何找第一次的（当前前缀和-给定值）的前缀和的下标，
 * 而（对称值，下标）的关系随步进指针逐步建立，而且特点正是只存第一次、也就是最早的那个。 这样找到一个，就能找到所有，再取个max，（而取max的过程也可以逐步做，这样就更加靠近普遍意义上的答案了）答案就出来了！
 *
 * @author Yabo
 * @date 2024/06/17
 */
public class LongestSubarraySumEqualsAim {

    public static int max = 100001;

    public static int[] arr = new int[max];

    public static int n, aim;

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        aim = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.write(compute());
        sc.pw.flush();

    }

    public static int compute() {
        // 1. 清空map，方便下次;数组清不清都可，反正会覆盖
        map.clear();
        // 2. 预存（0，-1）的关系对，意味着：在前缀和为0时，“下标”就已经存在了
        map.put(0, -1);
        // 3. 创建答案寄存器
        int ans = 0;
        // 4. for循环，遍历数组
        for (int i = 0, sum = 0; i < n; i++) {
            // 5. 首先计算前缀和，
            sum += arr[i];
            // 6. 其次寻找（当前前缀和-给定值）的前缀和的下标，找得到就和之前存下的ans比大小；找不到无需处理
            if (map.containsKey(sum - aim)) {
                ans = Math.max(ans, i - map.get(sum - aim));
            }
            // 7. 其次是存储关系对的问题：没有才存，已有不覆盖
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        // 8. 返回答案
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

