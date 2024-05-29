package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class lc381_RandomizedCollection {

    // 数-数字下标集合
    public HashMap<Integer, HashSet<Integer>> map;

    // 实际支撑插入，删除，随机查询为O(1)的结构
    public ArrayList<Integer> arr;

    public lc381_RandomizedCollection() {
        // 1. 简单的HashMap初始化
        map = new HashMap<>();
        // 2. 简单的ArrayList初始化
        arr = new ArrayList<>();
    }

    public static void main(String[] args) {
        // ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
        //  [[],[4],[3],[4],[2],[4],[4],[3],[4],[4]]
        lc381_RandomizedCollection s = new lc381_RandomizedCollection();
        s.insert(4);
        s.insert(3);
        s.insert(4);
        s.insert(2);
        s.insert(4);
        s.remove(4);
        s.remove(3);
        s.remove(4);
        s.remove(4);

    }

    public boolean insert(int val) {
        // 1. 将数加至数组末尾
        arr.add(val);
        // 2. 获取该数对应的下标集合，么有就新建
        HashSet<Integer> set = map.getOrDefault(val, new HashSet<>());
        // 3. 加进去
        set.add(arr.size() - 1);
        // 4. 更新map（有待验证如果set本身就存在，这一步是否还必要？……经验证，不必）
        if (set.size() == 1) {
            map.put(val, set);
        }
        // 5. 返回1和集合实时容量的比较，如果是true，说明是第一次插入；否则不是呗。
        return set.size() == 1;
    }

    public boolean remove(int val) {
        // 1. 先看看map里有没有这种映射关系，没有还移什么？
        if (!map.containsKey(val)) {
            return false;
        }
        // 2. 其次获取val对应的set1，
        HashSet<Integer> set1 = map.get(val);
        // 3. 随便从里面拿一个下标index，
        int index = set1.iterator().next();
        // 4. 干点别的：获取此时数组尾值及其下标
        int endIndex = arr.size() - 1;
        int endValue = arr.get(endIndex);
        // 5. 看看3、4的两个数值能不能对上？
        //     能得话直接先删set1中的index；
        //     不能，就这样：还是先准备（5.0. 获取尾值对应的集合set2）
        //         5.1. set1移除获取的下标index
        //         5.2. set2移除尾值的下标
        //         5.3. set2添加index
        //         5.4. 尾值覆盖数组index处的值
        if (val == endValue) {
            set1.remove(endIndex);
        } else {
            HashSet<Integer> set2 = map.get(endValue);
            set1.remove(index);
            set2.remove(endIndex);
            set2.add(index);
            arr.set(index, endValue);
        }
        // 7. 数组移除尾值……
        //     如果set1就此成空，那就map也把val与其set的对应也一并删除！
        arr.remove(arr.size() - 1);
        if (set1.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        // 1. 直接从数组中获取下标为以[0, 数组长度-1]的随机值就好
        return arr.get((int) (Math.random() * arr.size()));
    }
}
