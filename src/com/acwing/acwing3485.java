package com.acwing;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class acwing3485{

    // 二进制字典树
    static int N = 3100010;     // 2 * 10^6

    static int n, m;           // n个数，m次询问
    static int[][] tr = new int[N][2]; // 二叉字典树
    static int[] cnt = new int[N];    // 每个节点的计数
    static int idx = 0;              // 节点数
    static int[] s = new int[N];    // 前缀异或和


    static void insert(int x, int v){
        int p = 0;
        for(int i = 30; i >= 0; i --){
            int u = x >> i & 1;
            if(tr[p][u] == 0) tr[p][u] = ++ idx;
            p = tr[p][u];
            cnt[p] += v;
        }
    }

    static int query(int x){
        int res = 0, p = 0;
        for (int i = 30; i >= 0; i --){
            int u = x >> i & 1;
            if (cnt[tr[p][u ^ 1]] > 0){
                p = tr[p][u ^ 1];
                res = res * 2 + 1;
            } else {
                p = tr[p][u];
                res = res * 2;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Read scanner = new Read();
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            s[i] = s[i - 1] ^ x;
        }

        int res = 0;
        insert(s[0], 1);
        for (int i = 1; i <= n; i++) {
            if(i - m - 1 >= 0 ) insert(s[i - m - 1], -1);
            res = Math.max(res, query(s[i]));
            insert(s[i], 1);
        }
        scanner.write(Optional.of(res));
    }

    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

        //快读一个整数
        public int nextInt() throws Exception{
            st.nextToken();
            return (int) st.nval;
        }
        //写一个快写任何类型的方法
        public void write(Object o) throws Exception{
            pw.println(o);
        }

    }



}
