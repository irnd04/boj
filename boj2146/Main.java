package boj2146;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	int c;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", c=" + c + "]";
	}
	public Node(int y, int x, int c) {
		super();
		this.y = y;
		this.x = x;
		this.c = c;
	}
}

public class Main {
	
	static int N;
	static int[][] m;
	static int[][] g;
	static int[][] v;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static int min = 20000;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N;
	}
	
	static void dfs(int y, int x, int grp) {
		if (g[y][x] == grp) return;
		g[y][x] = grp;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			if (m[ny][nx] != 1) continue;
			dfs(ny, nx, grp);
		}
	}
	
	static int bfs(int y, int x, int grp, int vis) {
		LinkedList<Node> q = new LinkedList<Node>();
		v[y][x] = vis;
		q.offer(new Node(y, x, 0));
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (g[cur.y][cur.x] != 0 &&
					g[cur.y][cur.x] != grp) return cur.c;
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (g[ny][nx] == grp) continue;
				if (v[ny][nx] == vis) continue;
				v[ny][nx] = vis;
				q.offer(new Node(ny, nx, cur.c + 1));
			}
		}
		return -1;
	}
	
	static void print2dim(int[][] x) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = new int[N][N];
		g = new int[N][N];
		v = new int[N][N];
		int grp = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (m[i][j] != 1) continue;
				if (g[i][j] != 0) continue;
				dfs(i, j, grp++);
			}
		}
		
		int id = 100;
		int r;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (g[i][j] == 0) continue;
				r = bfs(i, j, g[i][j], id++);
				if (r == -1) continue;
				min = Math.min(min, r - 1);
			}
		}
		
		System.out.println(min);
		
	}
}

/*
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

*/