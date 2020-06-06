package boj13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static LinkedList<Integer>[] adj;
	static int V, E;
	static int[] visit = new int[5];
	
	static boolean chk(int v, int d) {
		for (int i = 0; i < d; i++)
			if (visit[i] == v) return true;
		return false;
	}
	
	static boolean dfs(int s, int d) {
		if (d == 5) return true;
		for (int next : adj[s]) {
			if (chk(next, d)) continue;
			visit[d] = next;
			if (dfs(next, d + 1)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new LinkedList[V];
		visit = new int[V];
		int from, to;
		for (int i = 0; i < V; i++) adj[i] = new LinkedList<Integer>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}
		
		for (int i = 0; i < V; i++) {
			visit[0] = i;
			if (dfs(i, 1)) {
				System.out.println(1);
				return;
			}
		}			
		System.out.println(0);
	}
	
}
/*
5 4
0 1
1 2
2 3
3 4
 */


/*
5 5
1 3
1 2
2 3
3 0
0 4
 */
