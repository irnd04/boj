package boj1707;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int V, E;
	static LinkedList<Integer>[] adj = new LinkedList[20001];
	static int[] color = new int[20001];
	
	static boolean dfs(int s, int c) {
		for (int next : adj[s]) {
			if (color[next] == c) return false;
			if (color[next] == 0) {
				color[next] = 3 - c;
				if (!dfs(next, 3 - c)) return false;
			}
		}
		return true;
	}
	
	static void solve() {
		for (int i = 1; i <= V; i++) {
			if (color[i] != 0) continue;
			color[i] = 1;
			if (!dfs(i, 1)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while (T --> 0) {
			V = sc.nextInt();
			E = sc.nextInt();
			int from, to;
			
			for (int i = 1; i <= V; i++) {
				adj[i] = new LinkedList<Integer>();
				color[i] = 0;
			}
				
			for (int i = 0; i < E; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				adj[from].add(to);
				adj[to].add(from);
			}
			
			solve();
			
		}
	}
}
/*
7 8
1 5
1 6
2 5
2 6
2 4
3 6
3 4
7 4
*/