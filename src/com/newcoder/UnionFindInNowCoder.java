package com.newcoder;

import java.io.*;

/**
 * 对我来说，这算并查集复习。<br />
 * 两个模板，一个优化拉满（路径压缩+小挂大+迭代），一个短小精悍。<br />
 *
 * @author Yabo
 * @date 2024/08/29
 */
public class UnionFindInNowCoder {

    public static int MAXN = 1000001;

    public static int[] father = new int[MAXN];

    public static int[] size = new int[MAXN];

    public static int[] stack = new int[MAXN];

    public static int n;

    public static void build() {
        // 1. 集合代表数组、集合大小数组的初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int i) {
        // 1. 设置记录途经节点个数的变量
        int size = 0;
        // 2. while循环，向根迭代的同时，将途经节点入栈。
        while (i != father[i]) {
            stack[size++] = i;
            i = father[i];
        }
        // 3. 路径压缩
        while (size > 0) {
            father[stack[--size]] = i;
        }
        return i;
    }

    public static void union(int x, int y) {
        // 1. 找到x的根
        int fx = find(x);
        // 2. 找到y的根
        int fy = find(y);
        // 3. 如果两根不等，则依据集合大小实行“小挂大”
        if (fx != fy) {
            if (size[fx] >= size[fy]) {
                size[fx] += size[fy];
                father[fy] = fx;
            } else {
                size[fy] += size[fx];
                father[fx] = fy;
            }
        }
    }

    public static boolean isSameSet(int x, int y) {
        // 1. 如果x的根等于y的根，则说明x和y在同一集合。
        return find(x) == find(y);
    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        int m = sc.nextInt();
        build();
        for (int i = 0, opt, x, y; i < m; i++) {
            opt = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            if (opt == 1){
                sc.write(isSameSet(x,y) ? "Yes\n" : "No\n");
            } else {
                union(x, y);
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
