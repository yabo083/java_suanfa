package com.acwing.base;

import java.io.*;


public class acwing338 {

    static int power10(int x){
        int res = 1;
        while (x -- > 0)
            res *= 10;
        return res;
    }

    static long count(int n, int x){
        long res = 0;
        int l, r, cnt = 0, m = n;
        while (m != 0){
            cnt ++;
            m /= 10;
        }

        for (int i = 1;i <= cnt; i ++){

            r = power10(i - 1);

            l = n/(r*10);

            if (x != 0)
                res += (long) l * r;
            else
                res += (long) (l - 1) * r;


            int d = (n / r) % 10;

            if (d == x)
                res += n % r + 1;
            else if (d > x)
                res += r;
        }

        return res;
    }

    static class Read{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public void write(Object o) {
            pw.print(o);
            pw.flush();
        }
    }

    public static void main(String[] args) throws IOException{
        int a, b;
        Read sc = new Read();
        a=sc.nextInt();
        b=sc.nextInt();
        while (a != 0 || b != 0){
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            for (int i = 0; i < 10; i ++)
                sc.write(count(b,i) - count(a-1,i) + " ");
            System.out.println();
            a = sc.nextInt();
            b = sc.nextInt();
        }
    }



}
