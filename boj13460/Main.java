package boj13460;

import java.util.Arrays;
import java.util.Scanner;

class Node {
	int y;
	int x;
	boolean fall;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", fall=" + fall + "]";
	}
	public Node(int y, int x, boolean fall) {
		super();
		this.y = y;
		this.x = x;
		this.fall = fall;
	}
	
}

public class Main {
	
	static int N;
	static int M;
	static char[][] B;
	static char[][] CB;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] move;
	static int[] res = new int[10];
	static int INF = Integer.MAX_VALUE;
	static int r = INF;
	// 0 up  
	// 1 down
	// 2 right
	// 3 left
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void printb() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(B[i][j]);
			}
			System.out.println();
		}
	}
	
	static Node move(int y, int x, int act) {
		int ny, nx;
		while (true) {
			ny = y + dy[act];
			nx = x + dx[act];
			if (!inrange(ny, nx)) return new Node(y, x, false);
			if (B[ny][nx] == 'R' || B[ny][nx] == 'B' || B[ny][nx] == '#') return new Node(y, x, false);
			if (B[ny][nx] == 'O') {
				B[y][x] = '.';
				return new Node(y, x, true);	
			}
			B[ny][nx] = B[y][x];
			B[y][x] = '.';
			y = ny;
			x = nx;
		}
	}
	
	static Node[] up() {
		Node[] ret = new Node[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (B[i][j] == 'R')
					ret[0] = move(i, j, 0);
				if (B[i][j] == 'B')
					ret[1] = move(i, j, 0);
			}
		}
		
		return ret;
	}
	
	static Node[] down() {
		Node[] ret = new Node[2];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (B[i][j] == 'R')
					ret[0] = move(i, j, 1);
				if (B[i][j] == 'B')
					ret[1] = move(i, j, 1);
			}
		}
		return ret;
	}
	
	static Node[] right() {
		Node[] ret = new Node[2];
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				if (B[i][j] == 'R')
					ret[0] = move(i, j, 2);
				if (B[i][j] == 'B')
					ret[1] = move(i, j, 2);
			}
		}
		return ret;
	}
	
	static Node[] left() {
		Node[] ret = new Node[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (B[i][j] == 'R')
					ret[0] = move(i, j, 3);
				if (B[i][j] == 'B')
					ret[1] = move(i, j, 3);
			}
		}
		return ret;
	}
	
	public static void perm(int p, int bef) {
		if (p == res.length) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					B[i][j] = CB[i][j];
				}
			}
			
			for (int i = 0; i < res.length; i++) {
				Node[] ret = null;
				if (res[i] == 0) ret = up();
				if (res[i] == 1) ret = down();
				if (res[i] == 2) ret = right();
				if (res[i] == 3) ret = left();
				if (ret[1].fall) return;
				if (ret[0].fall) {
					r = Math.min(r, i + 1);
					return;
				}
			}
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (i == bef) continue;
			res[p] = i;
			perm(p + 1, i);
		}
		
	}
	
	public static void main(String[] args) {
		int ry, rx, by, bx;
		ry = rx = by = bx = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		B = new char[N][M];
		CB = new char[N][M];
		for (int i = 0; i < N; i++) {
			CB[i] = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (CB[i][j] == 'R') {
					ry = i;
					rx = j;
				}
				if (CB[i][j] == 'B') {
					by = i;
					bx = j;
				}
			}
		}
		
		perm(0, 5);
		System.out.println(r == INF ? -1 : r);
		
	}
	
}

/*
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
 */
