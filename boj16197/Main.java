package boj16197;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int r1;
	int c1;
	int r2;
	int c2;
	int cnt;
	public Node(int r1, int c1, int r2, int c2, int cnt) {
		super();
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Node [r1=" + r1 + ", c1=" + c1 + ", r2=" + r2 + ", c2=" + c2 + ", cnt=" + cnt + "]";
	}
	
}

public class Main {
	
	static int N, M;
	static char[][] b;
	
	static int[][] coin = new int[2][];
	static int coini;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	public static int bfs() {
		Node s = new Node(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0);
		LinkedList<Node> q = new LinkedList<Node>();
		q.offer(s);
		int ny1, nx1, ny2, nx2;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			int out = 0;
			if (!inrange(cur.r1, cur.c1)) out++;
			if (!inrange(cur.r2, cur.c2)) out++;
			
			if (out == 2) continue;
			if (out == 1) return cur.cnt;
			
			if (cur.cnt == 10) continue;
			for (int i = 0; i < 4; i++) {
				ny1 = cur.r1 + dy[i];
				nx1 = cur.c1 + dx[i];
				ny2 = cur.r2 + dy[i];
				nx2 = cur.c2 + dx[i];
				
				if (inrange(ny1, nx1) && b[ny1][nx1] == '#') {
					ny1 = cur.r1;
					nx1 = cur.c1;
				}
				
				if (inrange(ny2, nx2) && b[ny2][nx2] == '#') {
					ny2 = cur.r2;
					nx2 = cur.c2;
				}
				
				q.offer(new Node(ny1, nx1, ny2, nx2, cur.cnt + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		b = new char[N][M];
		for (int i = 0; i < N; i++)
			b[i] = sc.next().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (b[i][j] == 'o') {
					b[i][j] = '.';
					coin[coini++] = new int[] {i, j};
				}
			}
		}
		
		System.out.println(bfs());
		
	}
}

/*
6 2
.#
.#
.#
o#
o#
##
 */