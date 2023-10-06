package com.acwing.base;

import java.io.*;
import java.math.BigInteger;

public class acwing876 {

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), p = sc.nextInt();
            if (a % p == 0) sc.write("impossible\n");
            else sc.write(qmi(a,p-2,p)+"\n");
//            calculate(sc.nextInt(),sc.nextInt());
        }
        sc.pw.flush();
    }

    private static long qmi(int a, int b, int p) {
        long res = 1;
        while (b > 0){
            if ((b & 1) == 1) res = res * a % p;
            a = (int) ((long)a * a % p);
            b >>= 1;
        }
        return res;
    }

    // api高手走此路，利用java的大数类提供的api计算，然后利用try catch分流
    private static void calculate(long a, long p) {
        int value;
        try {
            value = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(p)).intValue();
        } catch (Exception e) {
            sc.write("impossible\n");
            return;
        }
        sc.write(value+"\n");
    }



    public static class sc {

        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static <T> void write(T o) {
            pw.print(o);
        }


    }

}
