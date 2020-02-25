package boj1697;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int S;
	static int D;
	static int[] cost = new int[100001];
	static int[] back = new int[100001];
	
	static int bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		cost[S] = 0;
		q.offer(S);
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur == D) return cost[cur];
			if (cur - 1 >= 0 && cost[cur - 1] == -1) {
				cost[cur - 1] = cost[cur] + 1;
				back[cur - 1] = cur;
				q.offer(cur - 1);
			}
			if (cur + 1 <= 100000 && cost[cur + 1] == -1) {
				cost[cur + 1] = cost[cur] + 1;
				back[cur + 1] = cur;
				q.offer(cur + 1);
			}
			if (cur * 2 <= 100000 && cost[cur * 2] == -1) {
				cost[cur * 2] = cost[cur] + 1;
				back[cur * 2] = cur;
				q.offer(cur * 2);
			}
		}
		return -1;
	}
	
	static void t(int r) {
		if (r == -1) return;
		t(back[r]);
		System.out.print(r + " ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		D = sc.nextInt();
		for (int i = 0; i < 100001; i++) { cost[i] = -1; back[i] = -1; }
		int r = bfs();
		System.out.println(r);
		t(D);
	}
	
	
}
