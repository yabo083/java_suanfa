package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

class lc380_RandomizedSet {

    // 数-下标（不加这个结构，无法达到插入和删除都无法达到O（1））
    public HashMap<Integer, Integer> map;

    // 主要结构
    public ArrayList<Integer> arr;

    public lc380_RandomizedSet() {
        // 1. 初始化map；
        map = new HashMap<>();
        // 2. 初始化arr；
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        // 1. 先检查是否存在？
        if (map.containsKey(val)){
            return false;
        }
        // 2. 不存在，先记录数-下标映射关系，再插入数组尾部+1位置（注意先后！！）
        map.put(val, arr.size());
        arr.add(val);
        // 3. 返回true
        return true;
    }

    public boolean remove(int val) {
        // 1. 先检查是否存在？不在，返回false；
        if (!map.containsKey(val)){
            return false;
        }
        // 2. 如果在，再获取val对应的下标
        int valIndex = map.get(val);
        // 3. 再获取数组尾值
        int endVal = arr.get(arr.size() - 1);
        // 4. 覆盖
        arr.set(valIndex, endVal);
        // 6. map再存数组尾值和val对应下标的一对
        map.put(endVal, valIndex);
        // 5. 同步删除map中的val对
        map.remove(val);
        // 7. 此时数组尾部多余了，删掉！
        arr.remove(arr.size() - 1);
        // 8. 返回true
        return true;
    }

    public int getRandom() {
        // 1. 直接从数组中获取下标为以[0, 数组长度-1]的随机值就好
        return arr.get((int) (Math.random() * arr.size()));
    }

    public static void main(String[] args) {
        // ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        //[[],[1],[2],[2],[],[1],[2],[]]
        lc380_RandomizedSet s = new lc380_RandomizedSet();
        s.insert(1);
        s.remove(1);
        System.out.println(s.getRandom()); // 2
    }
}
