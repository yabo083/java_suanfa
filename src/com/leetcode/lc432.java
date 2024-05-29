package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class lc432 {

    public static Bucket head, tail;
    public static HashMap<String, Bucket> map;

    public lc432() {
        head = new Bucket(0, "");
        tail = new Bucket(Integer.MAX_VALUE, "");
        head.r = tail;
        tail.l = head;
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        // ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
        // [[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
        lc432 s = new lc432();
        s.inc("a");
        s.inc("b");
        s.inc("b");
        s.inc("c");
        s.inc("c");
        s.inc("c");
        s.dec("b");
        s.dec("b");
        System.out.println(s.getMinKey());
        s.dec("a");
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey()); // c

    }

    private void insert(Bucket cur, Bucket pos) {
        cur.r.l = pos;
        pos.r = cur.r;
        cur.r = pos;
        pos.l = cur;
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.r.cnt == 1) {
                map.put(key, head.r);
                head.r.set.add(key);
            } else {
                Bucket newBucket = new Bucket(1, key);
                map.put(key, newBucket);
                insert(head, newBucket);
            }
        } else {
            Bucket bucket = map.get(key);
            if (bucket.r.cnt == bucket.cnt + 1) {
                map.put(key, bucket.r);
                bucket.r.set.add(key);
            } else {
                Bucket newBucket = new Bucket(bucket.cnt + 1, key);
                map.put(key, newBucket);
                insert(bucket, newBucket);
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                remove(bucket);
            }
        }
    }

    public void dec(String key) {
        Bucket bucket = map.get(key);
        if (bucket.cnt == 1) {
            map.remove(key);
        } else {
            if (bucket.l.cnt == bucket.cnt - 1) {
                map.put(key, bucket.l);
                bucket.l.set.add(key);
            } else {
                Bucket newBucket = new Bucket(bucket.cnt - 1, key);
                map.put(key, newBucket);
                insert(bucket.l, newBucket);
            }
        }
        bucket.set.remove(key);
        if (bucket.set.isEmpty()) {
            remove(bucket);
        }
    }

    public String getMaxKey() {
        return tail.l.set.iterator().next();
    }

    public String getMinKey() {
        return head.r.set.iterator().next();
    }

    private void remove(Bucket cur) {
        cur.l.r = cur.r;
        cur.r.l = cur.l;
    }

    class Bucket {

        private HashSet<String> set;
        private int cnt;
        private Bucket l, r;

        private Bucket(int cnt, String str) {
            set = new HashSet<>();
            set.add(str);
            this.cnt = cnt;
        }

    }


}
