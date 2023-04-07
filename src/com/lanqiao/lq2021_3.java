package com.lanqiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lq2021_3 {

    static int N = 300000; // 结点总数
    static int M = 300000; // 边总数，根据数据范围设置
    static int INF = Integer.MAX_VALUE; // 无穷大

    static int[] h = new int[N + 1]; // 存储每个结点的链表头，初始值为-1
    static int[] e = new int[M]; // 存储每条边指向的结点
    static int[] ne = new int[M]; // 存储与每条边同一个起点的下一条边的下标
    static int idx = 0; // 存储当前边的下标
    static int[] dist = new int[N]; // 存储1号点到其他点的最短距离

    static boolean[] vis = new boolean[N]; // 存储每个结点是否被访问过

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    static void buildGraph() {
        // 遍历所有结点对
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                int diff = Math.abs(i - j);
                if (diff > 21) continue; // 如果差的绝对值大于21，则没有边相连
                int len = lcm(i, j); // 否则，连接一条长度为最小公倍数的边
                add(i, j);
                add(j, i);
                e[idx - 1] = len; // 存储边的长度
                e[idx - 2] = len;
            }
        }
    }

    // 使用Dijkstra算法求解最短路径
    static int dijkstra() {
//        int[] dist = new int[N]; // 存储起点到各结点的最短距离
        Arrays.fill(dist, INF);
//        boolean[] vis = new boolean[N]; // 记录每个结点是否已确定最短路径
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue)); // 小根堆，存储结点编号和距离

        dist[1] = 0;

        pq.offer(new Pair<>(1, 0));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int u = p.getKey();
            int d = p.getValue();

            if (vis[u]) {
                continue;
            }

            vis[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int v = e[i];
                int w = e[i ^ 1];
                if (!vis[v] && dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new Pair<>(v, dist[v]));
                }
            }
        }

        return dist[2022];
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getKey() {
            return first;
        }

        public V getValue() {
            return second;
        }
    }

    public static void main(String[] args) {
        Arrays.fill(h, -1);
        buildGraph();
        System.out.println(dijkstra());
    }




}
