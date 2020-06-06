package boj16928;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int M;
	static int[] next = new int[101];
	static int[] dist = new int[101];
	
	static void bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		dist[1] = 0;
		q.offer(1);
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur == 100) break;
			for (int i = 1; i <= 6; i++) {
				if (cur + i > 100) continue;
				if (dist[next[cur + i]] != -1) continue;
				dist[next[cur + i]] = dist[cur] + 1;
				q.offer(next[cur + i]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= 100; i++) {
			next[i] = i;
			dist[i] = -1;
		}
		
		for (int i = 0; i < N + M; i++) {
			next[sc.nextInt()] = sc.nextInt();
		}
		
		bfs();
		
		System.out.println(dist[100]);
		
	}
	
}
