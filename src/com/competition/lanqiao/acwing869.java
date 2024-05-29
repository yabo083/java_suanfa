package com.competition.lanqiao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class acwing869 {

    static List<Integer> get_divisors(int x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= x / i; i++)
            if (x % i == 0){
                res.add(i);
                if (i != x /i ) res.add(x/i);
            }
        Collections.sort(res);//这么排最快！？
//        p.sort(Comparator.comparingInt(a -> a));
        return res;
    }

    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        //快读一个整数
        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        //一个快写任何类型的方法,报错改成泛型
        public static  <T> void write(T o) {
            pw.println(o);
        }


    }

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n -- > 0 ){
            int x = sc.nextInt();
            List<Integer> res = get_divisors(x);
            for(Integer y : res){
                sc.write(y);
            }
        }
        sc.pw.flush();

    }


}
