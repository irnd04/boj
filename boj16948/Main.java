package boj16948;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + "]";
	}
	public Node(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}

public class Main {
	
	static int[] dy = {-2, -2, 0, 0, 2, 2};
	static int[] dx = {-1, 1, -2, 2, -1, 1};
	
	static int N;
	static Scanner sc = new Scanner(System.in);
	static int[][] dist;
	
	static int sy, sx, ey, ex;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N;
	}
	
	static void bfs() {
		LinkedList<Node> q = new LinkedList<Node>();
		dist[sy][sx] = 0;
		q.offer(new Node(sy, sx));
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			
			if (cur.y == ey && cur.x == ex) return;
			
			for (int i = 0; i < 6; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (dist[ny][nx] != -1) continue;
				dist[ny][nx] = dist[cur.y][cur.x] + 1;
				q.offer(new Node(ny, nx));
			}
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = -1;
			}
		}
		
		sy = sc.nextInt();
		sx = sc.nextInt();
		ey = sc.nextInt();
		ex = sc.nextInt();
		
		bfs();
		
		System.out.println(dist[ey][ex]);
	}
	
}
