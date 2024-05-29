package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

class lc895 {

    // 出现的最大次数
    private int MaxCount;
    // 数->出现次数
    private HashMap<Integer, Integer> ValueToCount;
    // 出现次数-存储出现了这么多次的数的数组
    private HashMap<Integer, ArrayList<Integer>> CountToValueArr;


    public lc895() {
        ValueToCount = new HashMap<>();
        CountToValueArr = new HashMap<>();
    }

    public static void main(String[] args) {
        // test
        lc895 s = new lc895();
        s.push(5);
        s.push(7);
        s.push(5);
        s.push(7);
        s.push(4);
        s.push(5);
        System.out.println(s.pop()); // 5
        System.out.println(s.pop()); // 7
        System.out.println(s.pop()); // 5
        System.out.println(s.pop()); // 4
        System.out.println(s.pop()); // 7
        System.out.println(s.pop()); // 5


    }

    public void push(int val) {
        // 1. 统计这个值出现的次数
        ValueToCount.put(val, ValueToCount.getOrDefault(val, 0) + 1);
        // 2. 再重新获取下这个值出现次数，目的是为了确定它是几层住户
        int curCount = ValueToCount.get(val);
        // 3. 承上，如果还没这层呢，就现盖一下
        CountToValueArr.computeIfAbsent(curCount, k -> new ArrayList<>());
        // 4. 反正总归是得拿到这层的钥匙
        ArrayList<Integer> curArr = CountToValueArr.get(curCount);
        // 5. 住进去
        curArr.add(val);
        // 6. 更新最高层指示器
        MaxCount = Math.max(curCount, MaxCount);
    }

    public int pop() {
        // 1. 根据指示器拿到最高层的钥匙
        ArrayList<Integer> curArr = CountToValueArr.get(MaxCount);
        // 2. 获取其中最后一个（其实就是符合题目要求的最接近栈顶的一个）
        Integer curValue = curArr.remove(curArr.size() - 1);
        // 3. 如果最高层因此空了，直接拆掉（同时记得指示器也同步楼层变化）
        if (curArr.isEmpty()) {
            CountToValueArr.remove(MaxCount--);
        }
        // 4. 再获取其出现次数，
        Integer curCount = ValueToCount.get(curValue);
        // 5. 如果次数为1，那根据pop的天然特性，此次pop后，直接移除该值的统计对；
        //     如果不是，简单减1后，重新存入即可。
        if (curCount == 1) {
            ValueToCount.remove(curValue);
        } else {
            ValueToCount.put(curValue, curCount - 1);
        }
        // 6. 返回ans。
        return curValue;
    }
}
