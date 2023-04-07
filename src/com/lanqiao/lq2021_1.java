package com.lanqiao;

import java.util.HashSet;

public class lq2021_1 {

    static class PII{
        long x, y;

        PII(double x, double y) {
            this.x = (long) (x * 1e6);
            this.y = (long) (y * 1e6);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(x) ^ Double.hashCode(y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof PII) {
                PII other = (PII) obj;
                return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0;
            }
            return false;
        }
    }

    static int N = 20, M = 21;

    static HashSet<PII> set = new HashSet<>();

    static void check(int x1, int y1, int x2, int y2){
        if (x1 == x2 || y1 == y2) return;
        double k = (y2 - y1) *1.0 / (x2 - x1);
        double b = (x2 * y1 - x1 * y2) *1.0 / (x2 - x1);
        set.add(new PII(k, b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i ++)
            for (int j = 0; j < M; j ++)
                for (int k = 0; k < N; k ++)
                    for (int l = 0; l < M; l ++)
                        check(i, j, k, l);
        System.out.println(set.size() + M + N);
//        System.out.println(159641);
    }

}
