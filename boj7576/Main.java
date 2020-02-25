package boj7576;

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
	
	static int[][] m;
	static int N, M;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void bfs(LinkedList<Node> q) {
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (m[ny][nx] != 0) continue;
				m[ny][nx] = cur.c + 1;
				q.offer(new Node(ny, nx, cur.c + 1));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Node> q = new LinkedList<Node>();
		M = sc.nextInt();
		N = sc.nextInt();
		m = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m[i][j] = sc.nextInt();
				if (m[i][j] == 1) q.offer(new Node(i, j, 1));
			}
		}
		
		bfs(q);
		
		boolean ok = true;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 0) ok = false;
				max = Math.max(m[i][j], max);
			}
		}
		if (!ok) System.out.println("-1");
		else System.out.println(max - 1);
		
	}
}

/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
*/