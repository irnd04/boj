package boj11726;

import java.util.Scanner;

public class Main {
	
	static int MOD = 10007;
	static int N;
	static int[][] b;
	static int[][][] t = new int[][][] {
		{{0, 0}, {0, 1}},   // 가로
		{{0, 0}, {1, 0}}    // 세로
	};
	static int[][][] d;
	
	public static int solve(int r, int c, int n) {
		if (n == 0) return 1;
		if (d[r][c][n] != -1) return d[r][c][n];
		
		int ret = 0;
		for (int type = 0; type < 2; type++) {
			if (chk(r, c, type)) {
				paint(r, c, type, 1);
				int[] p = pos();
				ret += solve(p[0], p[1], n - 1);
				ret %= MOD;
				paint(r, c, type, 0);
			}
		}
		d[r][c][n] = ret;
		return ret;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		b = new int[2][N];
		d = new int[2][N][N + 1];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N + 1; k++) {
					d[i][j][k] = -1;
				}
			}
		}
		
		System.out.println(solve(0, 0, N));
	}
	
	static boolean inrange(int r, int c) {
		return r >= 0 && c >= 0 && r < 2 && c < N;
	}
	
	static boolean chk(int r, int c, int type) {
		int nr, nc;
		for (int i = 0; i < 2; i++) {
			nr = r + t[type][i][0];
			nc = c + t[type][i][1];
			if (!inrange(nr, nc) || b[nr][nc] != 0) return false;
		}
		return true;
	}
	
	static void paint(int r, int c, int type, int x) {
		int nr, nc;
		for (int i = 0; i < 2; i++) {
			nr = r + t[type][i][0];
			nc = c + t[type][i][1];
			b[nr][nc] = x;
		}
	}
	
	static int[] pos() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				if (b[i][j] == 0)
					return new int[] {i, j};
			}
		}
		return new int[] {0, 0};
	}

}
