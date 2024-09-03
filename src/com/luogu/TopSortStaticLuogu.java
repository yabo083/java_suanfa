package com.luogu;

import java.io.*;
import java.util.Arrays;


/**
 * 拓扑排序+字典序输出<br />
 * 值得一练，主要是练习堆排序。<br />
 *
 * @author Yabo
 * @date 2024/09/03
 */
public class TopSortStaticLuogu {

    public static int N = 100001;

    public static int n, m, idx, heapSize;

    public static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], heap = new int[N], ans = new int[N];

    // 初始化函数
    public static void build(int n) {
        idx = 1;
        heapSize = 0;
        Arrays.fill(h, 0, n + 1, -1);
        Arrays.fill(d, 0, n + 1, 0);
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // 向堆末尾push，随后向上调整
    public static void push(int num) {
        int i = heapSize++;
        heap[i] = num;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    // 取堆顶，随后用堆尾填补缺漏，向下调整
    public static int pop() {
        int ans = heap[0];
        heap[0] = heap[--heapSize];
        // heapify的过程
        int i = 0;
        int l = 1;
        while (l < heapSize) {
            int best = l + 1 < heapSize && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
        return ans;
    }


    // 辅助函数
    public static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // 辅助函数
    public static boolean isEmpty() {
        return heapSize == 0;
    }

    public static void topSort() {
        // 1. 把入度为0的点都push到堆中
        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                push(i);
            }
        }
        // 2. while循环，直至堆为空，结束后ans中已放好按字典序排好的点值。
        int t = 0;
        while (!isEmpty()) {
            // 	1. 取堆顶
            int cur = pop();
            // 	2. 放入ans中
            ans[t++] = cur;
            // 	3. 遍历其邻接点，并将其入度减1，并对已经归0的点也push到堆中。
            for (int i = h[cur], j; i != -1; i = ne[i]) {
                j = e[i];
                if (--d[j] == 0) {
                    push(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 接受数据
        n = sc.nextInt();
        m = sc.nextInt();
        build(n);
        for (int i = 0, a, b; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            // 2. add边，修改入度
            add(a, b);
            d[b]++;
        }
        // 3. topSort()
        topSort();
        // 4. 按规则输出
        for (int i = 0; i < n - 1; i++) {
            sc.write(ans[i] + " ");
        }
        sc.write(ans[n - 1]);
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
