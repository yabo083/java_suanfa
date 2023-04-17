package com.acwing.base;

import java.io.*;

public class acwing789 {

    static final int N = 100010;
    static int n, m;
    static int[] q = new int[N];

    public static class Read {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public long nextLong() throws IOException {
            st.nextToken();
            return (long) st.nval;
        }

        //只能读取纯字符串的方法
        public String readLine() throws IOException {    //	不推荐使用
            st.nextToken();
            return st.sval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public void write(Object o) {
            pw.print(o);
            pw.flush();
        }
    }


    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i ++)
            q[i] = sc.nextInt();

        while (m -- > 0){
            int x = sc.nextInt();
            int l = -1,r = n;
            while(l+1!=r)//当l与r没有相接的时候,求边界
            {
                int mid=l + (r - l) /2;
                //下面找第一个>=5的坐标
                if(q[mid]>=x)
                    r=mid;
                else
                    l=mid;
            }
            if (q[r] != x) {
                sc.write("-1 -1");
                sc.pw.println();
            } else {
                sc.write(r + " ");
                l = -1;
                r = n ;
                while (l+1!=r){
                    int mid = l + (r - l) / 2;
                    if (q[mid] <= x)
                        l = mid;
                    else
                        r = mid ;
                }
                if (q[l] != x) sc.write(r);
                else sc.write(l);
                sc.pw.println();
            }
        }
    }
}
