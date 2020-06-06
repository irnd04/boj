package boj12100;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean[][] merge;
	static int[][] inp;
	static int[][] cinp;
	static int[] res = new int[5];
	static int N;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static int r = 0;
	
	// 0 up
	// 1 down
	// 2 right
	// 3 left
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N;
	}
	
	static void move(int y, int x, int act) {
		int ny, nx;
		while (true) {
			ny = y + dy[act];
			nx = x + dx[act];
			if (!inrange(ny, nx)) break;
			if (cinp[ny][nx] != 0) {
				if (cinp[y][x] == cinp[ny][nx] && !merge[ny][nx]) {
					merge[ny][nx] = true;
					cinp[y][x] = 0;
					cinp[ny][nx] *= 2;
				}
				break;
			}
			cinp[ny][nx] = cinp[y][x];
			cinp[y][x] = 0;
			y = ny;
			x = nx;
		}
	}
	
	static void action(int s1, int e1,
			int s2, int e2, int act) {
		int i1 = 1;
		int i2 = 1;
		if (s1 > e1) i1 = -1;
		if (s2 > e2) i2 = -1;
		for (int i = s1; i != e1; i += i1) {
			for (int j = s2; j != e2; j += i2) {
				if (cinp[i][j] != 0)
					move(i, j, act);
			}
		}
	}
	
	static void printarr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(cinp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void clear() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				merge[i][j] = false;
	}

	static void getmax() {
		for (int i = 0; i < res.length; i++) {
			clear();
			if (res[i] == 0) action(0, N, 0, N, 0);
			if (res[i] == 1) action(N - 1, -1, 0, N, 1);
			if (res[i] == 2) action(0, N, N - 1, -1, 2);
			if (res[i] == 3) action(0, N, 0, N, 3);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				r = Math.max(r, cinp[i][j]);
			}
		}
	}
	
	static void perm(int p) {
		
		if (p == 5) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cinp[i][j] = inp[i][j];
				}
			}
			
			getmax();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			res[p] = i;
			perm(p + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N][N];
		cinp = new int[N][N];
		merge = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				inp[i][j] = sc.nextInt();
				cinp[i][j] = inp[i][j];
			}
		}		
		perm(0);
		System.out.println(r);
		
//		while (true) {
//			int i = sc.nextInt();
//			clear();
//			if (i == 0) action(0, N, 0, N, 0);
//			if (i == 1) action(N - 1, -1, 0, N, 1);
//			if (i == 2) action(0, N, N - 1, -1, 2);
//			if (i == 3) action(0, N, 0, N, 3);
//			printarr();
//		}
	}
}
/*
10
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
2 2 2 2 2 2 2 2 2 2
*/
 