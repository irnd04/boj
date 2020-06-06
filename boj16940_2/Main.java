package boj16940_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adj;
	static int[] input;
	static int[] order;
	static boolean[] visit;
	
	static boolean bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		visit[1] = true;
		q.offer(1);
		int cur;
		int anschk = 0;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur != input[anschk++]) return false;
			for (int next : adj[cur]) {
				if (visit[next]) continue;
				visit[next] = true;
				q.offer(next);
			}
		}
		return true;
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
		System.out.println(bfs() ? 1 : 0);
			
	}
}
