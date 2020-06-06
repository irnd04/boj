package boj1261;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	int c;
	public Node(int y, int x, int c) {
		super();
		this.y = y;
		this.x = x;
		this.c = c;
	}
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", c=" + c + "]";
	}
	
}

public class Main {
	
	static int N, M;
	static char[][] b;
	static int[][] cost;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static final int INF = 40001;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void solve() {
		LinkedList<Node> q = new LinkedList<Node>();
		cost[0][0] = 0;
		q.offer(new Node(0, 0, 0));
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (b[ny][nx] == '1') {
					if (cur.c + 1 < cost[ny][nx]) {
						cost[ny][nx] = cur.c + 1;
						q.offer(new Node(ny, nx, cur.c + 1));
					}
					continue;
				}
				if (cur.c < cost[ny][nx]) {
					cost[ny][nx] = cur.c;
					q.offer(new Node(ny, nx, cur.c));
				}
			}
		}
	} 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		b = new char[N][M];
		cost = new int[N][M];
		for (int i = 0; i < N; i++)
			b[i] = sc.next().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cost[i][j] = INF;
			}
		}
		solve();
		System.out.println(cost[N - 1][M - 1]);
	}
	
}
