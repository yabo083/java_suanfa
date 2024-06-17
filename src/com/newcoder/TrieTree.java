package com.newcoder;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * tmd最终卡我的不是逻辑，而是初始化！
 * @author Yabo
 * @date 2024/06/13
 */
public class TrieTree {

    // 1. 最大值常量
    public static int max = 150001;
    // 2. 路径信息数组，行维度存储相互之间的关联，列维度对应字符
    public static int[][] tree = new int[max][26];
    // 3. 尾数组，存储多少字符串是以此结尾的
    public static int[] end = new int[max];
    // 4. 路过信息数组，存储多少字符串经过
    public static int[] pass = new int[max];
    // 5. 以上皆从1开始，而且以整型变量cnt的值对应其数组下标，作为“节点存在”
    public static int cnt;

    public static int m, op;

    public static String word;

    public static void main(String[] args) {
        cnt = 1;
        m = scpro.nextInt();
        for (int i = 0; i < m; i++) {
            op = scpro.nextInt();
            word = scpro.next();
            if (op == 1) {
                insert(word);
            } else if (op == 2) {
                delete(word);
            } else if (op == 3) {
                scpro.write(search(word) > 0 ? "YES\n" : "NO\n");
            } else {
                scpro.write(prefixNumber(word) + "\n");
            }
        }
        scpro.pw.flush();
        clear();
    }



    public static void insert(String word) {
        // 1. 一个局部变量，作为临时指针
        int cur = 1;
        // 2. 二话不说，先记录路过开始节点的信息
        pass[cur]++;
        // 3. for循环，把形参的字符一个个抠出来，依次拿到路径信息数组中查看，如果为0，那就新建；如果已有，那就临时指针直接跳过去，顺带记录路过信息。
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        // 4. 最后不用返回什么，把尾数组临时指针指示的位置，+1即可。
        end[cur]++;
    }

    public static int search(String word) {
        // 1. 一个局部变量，作为临时指针
        int cur = 1;
        // 2. for循环，把形参的字符一个个抠出来，依次拿到路径信息数组中查看，如果为0，那就 直接返回0示意不存在！如果已有，那就临时指针直接跳过去。
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        // 3. 最后返回尾数组临时指针指示的记录数就行
        return end[cur];
    }

    public static int prefixNumber(String pre) {
        // 1. 一个局部变量，作为临时指针
        int cur = 1;
        // 2. for循环，把形参的字符一个个抠出来，依次拿到路径信息数组中查看，如果为0，那就 直接返回0，示意不存在！如果已有，那就临时指针直接跳过去。
        for (int i = 0, path; i < pre.length(); i++) {
            path = pre.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        // 3. 最后返回路过数组临时指针指示的记录数就行
        return pass[cur];
    }

    public static void delete(String word) {
        // 1. 先得有才能删没问题吧？所以先用之前写好的方法看一眼，结果大于0再继续。
        if (search(word) > 0) {
            // 2. 还是先初始化一个局部变量，作为临时指针（tmd这话我都说了多少遍了？？
            int cur = 1;
            // 3. for循环，把形参的字符一个个抠出来，先从路径信息数组中获取对应的节点，随后再利用这节点获取预-1的路过信息（令人惊奇的是，这确实是可行的操作，反正迟早都是要更新路过信息的。虽然直接作废一条路径会有一些残余连接，但从逻辑上讲，不会影响什么）如果为0，那就 声明通过该字符向后的路不存在，同时直接返回！如果已有，那就临时指针直接跳过去，继续循环。
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[tree[cur][path]] == 0) {
                    tree[cur][path] = 0;
                    return;
                }
                cur = tree[cur][path];
            }
            // 4. 最后不用返回什么，尾数组临时指针指示的记录数--就行，代表删除成功！
            end[cur]--;
        }
    }

    public static void clear() {
        // 1. 把三个数组用的归零就行
        for (int i = 1; i <= cnt; i++) {
            end[i] = 0;
            pass[i] = 0;
            Arrays.fill(tree[i], 0);
        }
    }


    public static class scpro {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));//快写

        scpro() throws IOException {
        }

        //read类升级，由StreamTokenizer变成StringTokenizer，相比于readline读一行，这个方法可以读混合字符串和数字的一行而且只读取字符串。
        static String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        //快读一个整数
        static int nextInt() {
            return Integer.parseInt(next());
        }

        static long nextLong() {
            return Long.parseLong(next());
        }

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        //这下换成br，就可以读任意类型的字符串了
        static public String readLine() throws IOException {
            return br.readLine();
        }

        //一个快写任何类型的方法,报错改成泛型
        public static <T> void write(T o) {
            pw.print(o);
        }

    }
}
