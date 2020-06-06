package boj11725;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static LinkedList<Integer>[] adj;
	static int[] par;
	
	static void dfs(int s, int p) {
		if (par[s] != -1) return;
		par[s] = p;
		for (int next : adj[s])
			dfs(next, s);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int from, to;
		adj = new LinkedList[N + 1];
		par = new int[N + 1];
		for (int i = 1; i <= N; i++) { 
			adj[i] = new LinkedList<Integer>();
			par[i] = -1;
		}
		
		for (int i = 0; i < N - 1; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		dfs(1, 1);
		for (int i = 2; i <= N; i++)
			System.out.println(par[i]);
	}

}
/*
7
1 6
6 3
3 5
4 1
2 4
4 7
*/