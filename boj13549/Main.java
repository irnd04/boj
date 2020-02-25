package boj13549;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int S, D;
	static int[] cost = new int[200001];
	
	static boolean inrange(int x) {
		return 0 <= x && x < 200001;
	}
	
	static void solve() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		cost[S] = 0;
		q.offer(S);
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur == D) return;
			
			if (cur != 0) {
				for (int i = cur * 2; i < 200001; i *= 2) {
					if (cost[i] == -1) {
						cost[i] = cost[cur];
						q.offer(i);
					}
				}
			}
			
			if (inrange(cur - 1) && cost[cur - 1] == -1) {
				cost[cur - 1] = cost[cur] + 1;
				q.offer(cur - 1);
			}
			
			if (inrange(cur + 1) && cost[cur + 1] == -1) {
				cost[cur + 1] = cost[cur] + 1;
				q.offer(cur + 1);
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		D = sc.nextInt();
		for (int i = 0; i < 200001; i++) cost[i] = -1;
		solve();
		System.out.println(cost[D]);
		
	}
}
