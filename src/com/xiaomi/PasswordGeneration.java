package com.xiaomi;

import java.util.Scanner;

public class PasswordGeneration {

    static class Node {
        int i;
        boolean set;
        Node prev;

        public Node(int i, boolean set, Node prev) {
            this.i = i;
            this.set = set;
            this.prev = prev;
        }
    }

    static class PriorityQueue {
        private final boolean[] active;
        private int max;

        public PriorityQueue(int upperBound) {
            active = new boolean[upperBound + 1];
            active[0] = true;
            max = 0;
        }

        public void add(int i) {
            active[i] = true;
            if (i > max)
                max = i;
        }

        public void remove(int i) {
            active[i] = false;
            if (max == i)
                while (!active[max]) max--;
        }

        public int peek() {
            return max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            nodes[l] = new Node(i, true, nodes[l]);
            nodes[r + 1] = new Node(i, false, nodes[r + 1]);
        }
        long res = 0;
        PriorityQueue pq = new PriorityQueue(m);
        for (int index = 0; index < n; index++) {
            Node node = nodes[index];
            while (node != null) {
                if (node.set) {
                    pq.add(node.i);
                } else {
                    pq.remove(node.i);
                }
                node = node.prev;
            }
            int a_i = pq.peek();
            res = (res + (long) index * a_i) % 100000009L;
        }


        System.out.println(res);
    }
}
