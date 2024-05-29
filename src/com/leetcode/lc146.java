package com.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class lc146 {

    public static HashMap<Integer, Integer> map;

    public static Deque<Integer> LRU;

    public static int size;

    public lc146(int capacity) {
        size = capacity;
        LRU = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            LRU.removeLastOccurrence(key);
            LRU.offer(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (LRU.size() == size) {
                map.remove(LRU.poll());
            }
            LRU.offer(key);
            map.put(key, value);
        } else {
            LRU.removeLastOccurrence(key);
            LRU.offer(key);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        lc146 s = new lc146(1);
        s.put(2, 1);
        System.out.println(s.get(2)); // 1
        s.put(3, 2);
        System.out.println(s.get(2)); // -1
        System.out.println(s.get(3)); // 2
    }
}
