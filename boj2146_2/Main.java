package boj2146_2;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	int g;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", g=" + g + "]";
	}
	public Node(int y, int x, int g) {
		super();
		this.y = y;
		this.x = x;
		this.g = g;
	}
	
}

public class Main {
	
	static int N;
	static int[][] m;
	static int[][] g;
	static int[][] cost;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
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
	
	static int bfs() {
		int min = 20000;
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (g[i][j] == 0) continue;
				cost[i][j] = 0;
				q.offer(new Node(i, j, g[i][j]));
			}
		}
		
		int ny, nx;
		Node cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (g[ny][nx] == cur.g) continue;
				if (g[ny][nx] != 0) {
					min = Math.min(min, cost[cur.y][cur.x] + cost[ny][nx]);
					continue;
				}
				if (cost[ny][nx] != -1) continue;
				g[ny][nx] = cur.g;
				cost[ny][nx] = cost[cur.y][cur.x] + 1;
				q.offer(new Node(ny, nx, cur.g));
			}
		}
		return min;
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
		
		cost = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				cost[i][j] = -1;
		
		int r = bfs();
		System.out.println(r);
		
	}
}

/*
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 1 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

5
1 1 1 0 1
1 1 1 0 0
1 1 1 0 0
1 1 0 0 0
1 1 1 1 1

4
1 0 1 0
0 1 0 1
1 0 1 0
0 1 0 1

4
1 1 1 1
1 1 0 1
1 0 0 1
1 1 1 1

5
1 0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
1 1 0 0 1
*/