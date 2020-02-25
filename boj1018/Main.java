package boj1018;

import java.util.Scanner;

public class Main {
	
	static int[][] inp;
	static int[][] a = new int[8][8];
	static int[][] b = new int[8][8];
	static int N, M;
	
	static void printarr(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
	
	static int diff(int[][] m, int y, int x) {
		int c = 0;
		int ny, nx;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ny = y + i;
				nx = x + j;
				if (inp[ny][nx] != m[i][j]) c++;
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int as = 1;
		int bs = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		inp = new int[N][M];
		a = new int[N][M];
		b = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] chs = sc.next().toCharArray();
			for (int j = 0; j < chs.length; j++) {
				int r = chs[j] == 'W' ? 1 : 0;
				inp[i][j] = r;
			}
		}
		
		a[0][0] = 0;
		b[0][0] = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 0 && j == 0) continue;
				if (j == 0) {
					a[i][j] = 1 - a[i - 1][j];
				}
				else a[i][j] = 1 - a[i][j - 1];
				b[i][j] = 1 - a[i][j];
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (N - i >= 8 && M - j >= 8) {
					min = Math.min(min, Math.min(diff(a, i, j), diff(b, i, j)));
				}
			}
		}
		
		System.out.println(min);
	}
}

/*
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
*/
