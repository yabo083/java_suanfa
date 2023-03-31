package com.acwing;

import java.io.*;
import java.util.Optional;

public class acwing5 {
    static int N = 11010, n, m, cnt;
    static int[] v = new int[N], w = new int[N], f = new int[N];

    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i ++){
            int a, b ,s;
            a = sc.nextInt();
            b = sc.nextInt();
            s = sc.nextInt();
            int k = 1;
            while (k <= s){
                cnt ++;
                v[cnt] = a * k;
                w[cnt] = b * k;
                s -= k;
                k *= 2;
            }
            if (s > 0){
                cnt ++;
                v[cnt] = a * s;
                w[cnt] = b * s;
            }
            n = cnt;
        }

        for (int i = 1; i <= n; i ++){
            for (int j = m; j >= v[i]; j --){
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        sc.write(Optional.of(f[m]));
        sc.pw.flush();

    }

    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public void write(Object o) {
            pw.println(o);
        }
    }




}
