package boj16940;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static LinkedList<Integer>[] adj;
	static int[] input;
	static boolean[] visit;
	static int[] par;
	
	static boolean chkbfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		visit[1] = true;
		q.offer(1);
		int cur, idx = 1;
		int cnt;
		int anschk = 0;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur != input[anschk++]) return false;
			cnt = 0;
			for (int next : adj[cur]) {
				if (visit[next]) continue;
				par[next] = cur;
				cnt++;
			}
			for (int i = idx; i < idx + cnt; i++) {
				if (par[input[i]] != cur) return false;
				visit[input[i]] = true;
				q.offer(input[i]);
			}
			idx += cnt;
		}
		if (anschk != N) return false;
		return true;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new LinkedList[N + 1];
		input = new int[N];
		visit = new boolean[N + 1];
		par = new int[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new LinkedList<Integer>();
		int from, to;
		for (int i = 0; i < N - 1; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();
		
		System.out.println(chkbfs() ? 1 : 0);
		
	}
}
/*
9
1 2
1 3
1 4
4 5
5 6
7 4
3 9
3 8
1 2 3 4 8 9 5 7 6


1
*/