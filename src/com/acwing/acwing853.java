package com.acwing;

import java.io.*;
import java.util.Arrays;

public class acwing853 {
	
	static int N = 510, M = 10010;
	
	static class Edge{
		int a, b, c;
	    public Edge(int a,int b,int c){
	        this.a = a;
	        this.b = b;
	        this.c = c;
	    }
	}
	
	static Edge[] edges = new Edge[M];
	
	static int n, m , k;
	static int[] dist = new int[N];
	static int[] last = new int[N];
	
	static void bellman_ford() {
		Arrays.fill(dist, 0x3f);
		
		dist[1] = 0;
		for (int i = 0; i < k; i ++) {
			last = Arrays.copyOf(dist,n+1);
			for (int j = 0; j < m; j ++ ) {
				Edge e = edges[j];
				dist[e.b] = Math.min(dist[e.b], last[e.a] + e.c);
				
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
			Read sc = new Read();
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			for (int i = 0; i < m; i ++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				edges[i] = new Edge(a,b,c);
			}

			bellman_ford();

			if (dist[n]  > 0x3f3f3f3f / 2) System.out.println("impossible");
			else System.out.println(dist[n]	);
	}

	static class Read{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));//快写

		public int nextInt() throws Exception{
			st.nextToken();
			return (int) st.nval;
		}

		public void write(Object o) throws Exception{
			pw.println(o);
		}
	}
}
