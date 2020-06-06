package boj16964;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adj;
	static int[] input;
	static int[] order;
	static boolean[] visit;
	static int anschk;
	static boolean f = true;
	
	static void dfs(int v) {
		if (visit[v]) return;
		visit[v] = true;
		if (v != input[anschk++]) f = false;
		for (int next : adj[v]) dfs(next);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new ArrayList[N + 1];
		input = new int[N];
		order = new int[N + 1];
		visit = new boolean[N + 1];
		int from, to;
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
			order[input[i]] = i;
		}
		
		for (int i = 1; i <= N; i++)
			Collections.sort(adj[i], (a, b) -> order[a] - order[b]);
		
		dfs(1);
		System.out.println(f ? 1 : 0);
			
	}
}
