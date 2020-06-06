package boj1987;

import java.util.Scanner;

public class Main {
/*	
2 4
CAAB
ADCB
*/
	
	static int N, M;
	static char[][] B;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0}; 
	static boolean[] chk;
	static int R = 0;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static void solve(int y, int x, int r) {
		int idx = B[y][x] - 'A';
		if (chk[idx]) {
			R = Math.max(r, R);
			return;
		}
		chk[idx] = true;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			solve(ny, nx, r + 1);
		}
		chk[idx] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		B = new char[N][M];
		chk = new boolean[30];
		for (int i = 0; i < N; i++) {
			B[i] = sc.next().toCharArray();
		}
		solve(0, 0, 0);
		System.out.println(R);
	}
}
