package boj16929;

import java.util.Scanner;

public class Main {
	
	static int N, M;
	static char[][] c;
	static int[][] v;
	
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static boolean dfs(int y, int x, int d, char color) {
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			if (c[ny][nx] != color) continue;
			if (v[ny][nx] != 0) {
				if (d - v[ny][nx] >= 3) return true;
				continue;
			}
			v[ny][nx] = d + 1;
			if (dfs(ny, nx, d + 1, color)) return true;
		}
		return false;
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		c = new char[N][M];
		v = new int[N][M];
		for (int i = 0; i < N; i++)
			c[i] = sc.next().toCharArray();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (v[i][j] != 0) continue;
				v[i][j] = 1;
				if (dfs(i, j, 1, c[i][j])) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}
}

/*
5 5
YYYRY
BYBYY
BBBBB
BBYYY
ZZZZZ
*/
