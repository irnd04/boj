package boj10026;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10026
// 적록색약
// 적록색약은 적색과 녹색을 구분을 못한다.
// 일반인이 보는 그룹의수와 적록색약이 보는 그룹의수를 구하는 문제
// 간단한 dfs문제

public class Main {
	
	static char[][] rg;
	static char[][] inp;
	static boolean[][] v;
	static boolean[][] rgv;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int N;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N; 
	}
	
	static void dfs(int y, int x, int val, char[][] m, boolean[][] chk) {
		if (chk[y][x]) return;
		chk[y][x] = true;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			if (m[ny][nx] != val) continue;
			dfs(ny, nx, val, m, chk);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int rgc = 0, c = 0;
		
		rg = new char[N][N];
		inp = new char[N][N];
		rgv = new boolean[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			inp[i] = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				rg[i][j] = 0;
				if (inp[i][j] == 'R' || inp[i][j] == 'G') rg[i][j] = 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!rgv[i][j]) {
					rgc++;
					dfs(i, j, rg[i][j], rg, rgv);
				}
				if (!v[i][j]) {
					c++;
					dfs(i, j, inp[i][j], inp, v);
				}
			}
		}
		
		System.out.println(c + " " + rgc);
		
	}
	
}
