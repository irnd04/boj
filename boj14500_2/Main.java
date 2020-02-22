package boj14500_2;

import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[][] inp;
	static boolean[][] chk;
	static int size = 4;
	
	static int spe[][][] = {
		// た
		{
			{0, 0}, {1, 0}, {2, 0}, {1, 1}
		},
		// っ
		{
			{1, 0}, {0, 1}, {1, 1}, {2, 1}
		},
		// で
		{
			{0, 1}, {1, 0}, {1, 1}, {1, 2} 
		},
		// ぬ
		{
			{0, 0}, {0, 1}, {0, 2}, {1, 1}
		}
	};
	
	static int[] dy = {0, 1, -1, 0};
	static int[] dx = {1, 0, 0, -1};
	
	static int special(int y, int x) {
		int max = 0;
		int ny, nx;
		for (int i = 0; i < spe.length; i++) {
			int sum = 0;
			boolean brk = false;
			for (int j = 0; j < 4; j++) {
				ny = y + spe[i][j][0];
				nx = x + spe[i][j][1];
				if (!inrange(ny, nx)) {
					brk = true;
					break;	
				}
				sum += inp[ny][nx];
			}
			if (brk) continue;
			max = Math.max(max, sum);
		}
		return max;
	}
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int solve(int y, int x, int s) {
		if (s == size - 1) return inp[y][x];
		int ny, nx;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			if (chk[ny][nx]) continue;
			chk[ny][nx] = true;
			max = Math.max(max, solve(ny, nx, s + 1));
			chk[ny][nx] = false;
		}
		return inp[y][x] + max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		inp = new int[N][M];
		chk = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				inp[i][j] = sc.nextInt();
			}
		}
		int r = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				chk[i][j] = true;
				int max = Math.max(solve(i, j, 0), special(i, j));
				chk[i][j] = false;
				r = Math.max(r, max);
			}
		}
		System.out.println(r);		
	}
}
/*
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

4 5
1 2 6 5 5
1 2 6 6 5
1 2 6 4 5
1 2 3 4 5
*/