package boj9019;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	static int[] num = new int[4];
	static int from, to;
	static Scanner sc = new Scanner(System.in);
	static final int LEN = 10000;
	static int[] dist = new int[LEN];
	static int[] prev = new int[LEN];
	static char[] how = new char[LEN];
	
	static void track(int n) {
		if (prev[n] == -1) return;
		track(prev[n]);
		System.out.print(how[n]);
	}
	
	static void clear() {
		for (int i = 0; i < LEN; i++) {
			dist[i] = -1;
			prev[i] = -1;
			how[i] = 0;
		}
	}
	
	static void toarray(int n) {
		for (int i = num.length - 1; i >= 0; i--) {
			num[i] = n % 10;
			n /= 10;
		}
	}
	
	static int tonum() {
		int r = 0;
		for (int i = 0; i < num.length; i++) {
			r *= 10;
			r += num[i];		
		}
		return r;
	}
	
	static int r(int n) {
		toarray(n);
		int temp = num[num.length - 1];
		for (int i = num.length - 1; i >= 1; i--) {
			num[i] = num[i - 1];
		}
		num[0] = temp;
		return tonum();
	}
	
	static int l(int n) {
		toarray(n);
		int temp = num[0];
		for (int i = 1; i < num.length; i++)
			num[i - 1] = num[i];
		num[3] = temp;
		return tonum();
	}
	
	static int s(int n) {
		if (n == 0) return 9999;
		return n - 1;
	}
	
	static int d(int n) {
		return (n * 2) % 10000;
	}
	
	static void bfs() {
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(from);
		dist[from] = 0;
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			
			if (cur == to) return;
			
			int next = d(cur);
			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				prev[next] = cur;
				how[next] = 'D';
				q.offer(next);
			}
			next = s(cur);
			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				prev[next] = cur;
				how[next] = 'S';
				q.offer(next);
			}
			next = l(cur);
			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				prev[next] = cur;
				how[next] = 'L';
				q.offer(next);
			}
			next = r(cur);
			if (dist[next] == -1) {
				dist[next] = dist[cur] + 1;
				prev[next] = cur;
				how[next] = 'R';
				q.offer(next);
			}
		}
		
		return;
		
	}
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		while (T --> 0) {
			from = sc.nextInt();
			to = sc.nextInt();
			clear();
			bfs();
			// 1234 3412
			track(to);
			System.out.println();
		}
		
	}
}
