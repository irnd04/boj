package boj1285;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1285
// 동전 뒤집기
// 브루트포스문제
// 행에 대해서 모든방법을 다시도함 2^20
// 시도하고 난후 열은 뒤집을지 말지만 결정하면된다.

public class Main {
	
	static int N;
	static int[] res;
	static int[][] inp;
	static int[][] cinp;
	static int ans = 9090990;
	
	static void copy(int[][] a, int[][] b) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] = b[i][j];
	}
	
	static void rowchange(int r) {
		for (int i = 0; i < N; i++) inp[r][i] = 1 - inp[r][i];
	}
	
	static int count() {
		int r = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += inp[j][i] == 1 ? 1 : 0;
			}
			r += Math.min(sum, N - sum);
		}
		return r;
	}
	
	static void perm(int p) {
		
		if (p == N) {
			copy(inp, cinp);
			for (int i = 0; i < N; i++)
				if (res[i] == 1) rowchange(i);
			ans = Math.min(ans, count());
			return;
		}
		
		for (int i = 0; i <= 1; i++) {
			res[p] = i;
			perm(p + 1);
		}
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new int[N];
		inp = new int[N][N];
		cinp = new int[N][N];
		char[] chs;
		for (int i = 0; i < N; i++) {
			chs = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				inp[i][j] = chs[j] == 'H' ? 1 : 0;
			}
		}
		copy(cinp, inp);
		perm(0);
		System.out.println(ans);
	}
	
}
/*
3
HHT
THH
THT

*/