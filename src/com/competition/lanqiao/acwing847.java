package com.competition.lanqiao;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class acwing847 {

    static int N = 100010;

    static int n, m, idx;
    static int[] h = new int[N], e = new int[N], ne = new int[N], d = new int[N], q = new int[N];//(Distance - 距离)

    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

//    static int bfs(){
//        Arrays.fill(d, -1);
//        Queue<Integer> q = new LinkedList<>();
//        d[1] = 0;
//        q.add(1);
//
//        while (q.size() != 0){
//            int t = q.remove();
//
//            for (int i = h[t]; i != -1; i = ne[i]){
//                int j = e[i];
//                if (d[j] == -1){
//                    d[j] = d[t] + 1;
//                    q.add(j);
//                }
//            }
//        }
//        return d[n];
//    }

    static int bfs()
    {
        int hh=0,tt=0;

        q[0]=1; //0号节点是编号为1的节点

        Arrays.fill(d, -1);

        d[1]=0; //存储每个节点离起点的距离

        //当我们的队列不为空时
        while(hh<=tt)
        {
            //取出队列头部节点
            int t=q[hh++];

            //遍历t节点的每一个邻边
            for(int i=h[t];i!=-1;i=ne[i])
            {
                int j=e[i];
                //如果j没有被扩展过
                if(d[j]==-1)
                {
                    d[j]=d[t]+1; //d[j]存储j节点离起点的距离，并标记为访问过
                    q[++tt] = j; //把j结点 压入队列
                }
            }
        }

        return d[n];
    }




    static class sc {
        static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        public static int nextInt() throws IOException {
            st.nextToken();
            return (int) st.nval;
        }

        public static  <T> void write(T o) {
            pw.print(o);
            pw.flush();
        }


    }

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }

        sc.write(bfs());

    }


}
