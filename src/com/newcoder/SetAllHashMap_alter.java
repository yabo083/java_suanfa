package com.newcoder;

import java.io.*;
import java.util.HashMap;


/**
 * 使用读写分离，确实快了点
 *
 * @author Yabo
 * @date 2024/05/28
 */
public class SetAllHashMap_alter {

    public static HashMap<Integer, int[]> map = new HashMap<>();

    public static int cnt, setAllValue, setAllTime = -1, n;

    public static int[][] op = new int[100001][3];
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            op[i][0] = sc.nextInt(); // 读取操作类型
            op[i][1] = sc.nextInt(); // 读取第一个参数

            // 只有操作类型为1时，才会有第三个参数
            if (op[i][0] == 1) {
                op[i][2] = sc.nextInt(); // 读取第二个参数
            }

        }
        for (int i = 0; i < n; i++) {
            if (op[i][0] == 1) {
                map.put(op[i][1], new int[]{op[i][2], cnt++});
            } else if (op[i][0] == 2) {
                if (map.containsKey(op[i][1])){
                    tmp = map.get(op[i][1]);
                    if (tmp[1] > setAllTime) {
                        sc.pw.write(tmp[0]+ "\n");
                    } else {
                        sc.pw.write(setAllValue + "\n");
                    }
                } else {
                    sc.pw.write(-1 + "\n");
                }
            } else {
                setAllValue = op[i][1];
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
