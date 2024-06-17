package com.newcoder;

import java.io.*;
import java.util.HashMap;

/**
 * 这个我只讲一句：
 *
 * 核心就是：
 *
 * 一是你先得把数组转换，像这个就通过将数组中的正、负数转换成1、-1的办法成功将“个数”用“和”这个属性表示了出来。
 *
 * 二就是，核心了：
 * 如果一个值，先后出现两次，说明中间的变化毫无影响，说明中间的值-1和1的个数相当，乃至相互抵消，或者都是0。
 *
 * 三就是，map预存（0,-1）的原因：因题而异，求长度，存（0,-1）；求个数，存（0,1）
 *
 * @author Yabo
 * @date 2024/06/17
 */
public class PositivesEqualsNegtivesLongestSubarray {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n= sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num != 0 ? (num > 0 ? 1 : -1): 0;
        }
        sc.write(compute());
        sc.pw.flush();
    }

    public static int compute() {
        // 1. map清空，数组不用
        map.clear();
        // 2. 预存（0,-1）
        map.put(0, -1);
        // 3. 创建答案寄存器
        int ans = 0;
        // 4. for循环，步进，计算前缀和，在map里找二次出现的值，根据取出的下标计算长度，和之前的值取max；因为是找和存都是同一个值，所以可以将没找到的情况写在else中
        for (int i = 0, sum = 0; i < n; i++){
            sum += arr[i];
            if (map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            } else
                map.put(sum, i);
        }
        // 5. 返回答案
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
