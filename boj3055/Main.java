package boj3055;

import java.util.LinkedList;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/3055
탈출
물이 퍼져나감을 먼저 계산
현재 몇초가 지났는지도 배열에서 확인하여 물이 1초뒤에 현재자리로 오는지 판단.
*/

class Node {
	int y;
	int x;
	int sec;
	
	public Node(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	public Node(int y, int x, int sec) {
		super();
		this.y = y;
		this.x = x;
		this.sec = sec;
	}

	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", sec=" + sec + "]";
	}
}

public class Main {
	
	static int N, M;
	static int[][] m;
	static int[][][] dist;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void water(LinkedList<Node> q) {
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur =  q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (m[ny][nx] != -1) continue;
				m[ny][nx] = m[cur.y][cur.x] + 1;
				q.offer(new Node(ny, nx));
			}
		}
	}
	
	static int go(int y, int x) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.offer(new Node(y, x, 0));
		dist[0][y][x] = 0;
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			
			if (m[cur.y][cur.x] == -100) return dist[cur.sec][cur.y][cur.x];
			
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (dist[cur.sec + 1][ny][nx] != -1) continue;
				if (m[ny][nx] == -2) continue;
				if (m[ny][nx] == -100 || m[ny][nx] == -1 || cur.sec + 2 <= m[ny][nx]) {
					dist[cur.sec + 1][ny][nx] = dist[cur.sec][cur.y][cur.x] + 1;
					q.offer(new Node(ny, nx, cur.sec + 1));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		// 갈수있음 -1 .
		// 갈수없음 -2 X
		// 물 0 ~
		// 스타트 -99
		// 도착 -100
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		m = new int[N][M];
		char[] chs;
		int x = -7;
		int sy = -1, sx = -1;
		
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (int i = 0; i < N; i++) {
			chs = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (chs[j] == '.') x = -1;
				else if (chs[j] == 'X') x = -2;
				else if (chs[j] == '*') {
					q.offer(new Node(i, j));
					x = 0;
				}
				else if (chs[j] == 'D') x = -100;
				else if (chs[j] == 'S') {
					sy = i;
					sx = j;
					x = -1;
				}
				m[i][j] = x;
			}
		}
		
		water(q);	
		dist = new int[N * M][N][M];
		for (int i = 0; i < N * M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					dist[i][j][k] = -1;
				}
			}
		}
		
		int r = go(sy, sx);
		System.out.println(r == -1 ? "KAKTUS" : r);				
	}
}
/*
3 3
DX*
.XX
..S
*/