package com.acwing;

import java.io.*;
import java.util.Scanner;

public class acwing1249 {

    static int N = 20010;
    static int[] p = new int[N];

    static int n, m;


    public static void main(String[] args) throws Exception {
        Read scanner = new Read();
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= n; i++) p[i] = i;

        while(m -- != 0) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            p[find(a)] = find(b);
        }

        m = scanner.nextInt();
        while(m -- != 0){
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            if(find(a) == find(b)) scanner.write("Yes");
            else scanner.write("No");
        }
        scanner.pw.flush();
    }

    public static int find(int x){
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
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
