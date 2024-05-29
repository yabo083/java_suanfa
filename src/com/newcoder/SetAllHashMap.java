package com.newcoder;

import java.io.*;
import java.util.HashMap;

public class SetAllHashMap {

    public static HashMap<Integer, int[]> map = new HashMap<>();

    public static int cnt, setAllValue, setAllTime = -1, n;

    public static int op, a, b;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            op = sc.nextInt(); // 读取操作类型
            a = sc.nextInt(); // 读取第一个参数

            // 只有操作类型为1时，才会有第三个参数
            if (op == 1) {
                b = sc.nextInt(); // 读取第二个参数
            }

            if (op == 1) {
                map.put(a, new int[]{b, cnt++});
            } else if (op == 2) {
                if (map.containsKey(a)){
                    int[] tmp = map.get(a);
                    if (tmp[1] > setAllTime) {
                        sc.pw.write(map.get(a)[0]+ "\n");
                    } else {
                        sc.pw.write(setAllValue + "\n");
                    }
                } else {
                    sc.pw.write(-1 + "\n");
                }
            } else {
                setAllValue = a;
                setAllTime = cnt++;
            }
        }
        sc.pw.flush();
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
