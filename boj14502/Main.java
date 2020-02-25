package boj14502;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	static int N, M;
	static Scanner sc = new Scanner(System.in);
	static int[][] inp;
	static int[][] inpc;
	static int[] res = new int[3];
	static ArrayList<Node> pos = new ArrayList<Node>();
	static int max = 0;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void copy() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				inp[i][j] = inpc[i][j];
	}
	
	static void printarr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(inp[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void comb(int p, int s) {
		
		if (p == res.length) {
			copy();
			for (int i = 0; i < res.length; i++) {
				Node cur = pos.get(res[i]);
				inp[cur.y][cur.x] = 1;
			}
			int r = bfs();
			max = Math.max(max, r);
			return;
		}
		
		for (int i = s; i < pos.size(); i++) {
			res[p] = i;
			comb(p + 1, i + 1);
		}
		
	}
	
	static int bfs() {
		LinkedList<Node> q = new LinkedList<Node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (inp[i][j] == 2)
					q.offer(new Node(i, j));
			}
		}
		Node cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (inp[ny][nx] != 0) continue;
				inp[ny][nx] = 2;
				q.offer(new Node(ny, nx));
			}
		}
		
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (inp[i][j] == 0) c++;
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		
		inp = new int[N][M];
		inpc = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				inp[i][j] = sc.nextInt();
				inpc[i][j] = inp[i][j];
				if (inp[i][j] == 0)
					pos.add(new Node(i, j));
			}
		}
		
		comb(0, 0);
		
		System.out.println(max);
		
		/*
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int v = i * M + j;
				String s = String.format("(%s, %s) ", v / M, v % M);
				System.out.print(s);
			}
			System.out.println();
		}
		*/
	}
}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

*/