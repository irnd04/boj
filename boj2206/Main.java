package boj2206;

import java.util.LinkedList;
import java.util.Scanner;

// 벽 부수고 이동하기 2206

class Node {
	int y;
	int x;
	int broken;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", broken=" + broken + "]";
	}
	public Node(int y, int x, int broken) {
		super();
		this.y = y;
		this.x = x;
		this.broken = broken;
	}
}

public class Main {
	
	static int[][][] dist = new int[1000][1000][2];
	static char[][] inp = new char[1000][1000];
	static int N, M;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int bfs() {
		// 0 아직안부숨
		// 1 부숨
		Node cur;
		int ny, nx;
		LinkedList<Node> q = new LinkedList<Node>();
		dist[0][0][0] = 1;
		q.offer(new Node(0, 0, 0));
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.y == N - 1 && cur.x == M - 1) return dist[cur.y][cur.x][cur.broken];
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				
				if (inp[ny][nx] == '0' && dist[ny][nx][cur.broken] == -1) {
					dist[ny][nx][cur.broken] = dist[cur.y][cur.x][cur.broken] + 1;
					q.offer(new Node(ny, nx, cur.broken));
				}
					
				if (cur.broken == 0 && inp[ny][nx] == '1' && dist[ny][nx][1] == -1) {
					dist[ny][nx][1] = dist[cur.y][cur.x][cur.broken] + 1;
					q.offer(new Node(ny, nx, 1));
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 0; i < N; i++) {		
			char[] chs = sc.next().toCharArray();
			for (int j = 0; j < chs.length; j++) {
				dist[i][j][0] = dist[i][j][1] = -1;
				inp[i][j] = chs[j];
			}
		}
		System.out.println(bfs());
	}
}

/*
6 4
0100
1110
1000
0000
0111
0000
*/