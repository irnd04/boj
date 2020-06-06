package boj14500;

import java.util.Scanner;

public class Main {
	
	static int[][][] tet = {
		// ぱ
		{
			{0, 0}, {0, 1}, {0, 2}, {0, 3}
		},
		// |
		{
			{0, 0}, {1, 0}, {2, 0}, {3, 0}
		},
		// け
		{
			{0, 0}, {1, 0}, {0, 1}, {1, 1}
		},
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
		},
		// |_
		//   |
		{
			{0, 0}, {1, 0}, {1, 1}, {2, 1}
		},
		//  _|
		// |
		{
			{0, 1}, {1, 0}, {1, 1}, {2, 0}
		},
		//   _
		// _|
		{
			{1, 0}, {1, 1}, {0, 1}, {0, 2}
		},
		// _
		//  |_
		{
			{0, 0}, {0, 1}, {1, 1}, {1, 2}
		},
		// い
		{
			{0, 0}, {1, 0}, {2, 0}, {2, 1}
		},
		// _|
		{
			{2, 0}, {2, 1}, {1, 1}, {0, 1}
		},
		// ぁ
		{
			{0, 0}, {0, 1}, {1, 1}, {2, 1}
		},
		//  _
		// |
		{
			{0, 0}, {0, 1}, {1, 0}, {2, 0}
		},
		// ___|
		{
			{1, 0}, {1, 1}, {1, 2}, {0, 2}
		},
		// |___
		{
			{0, 0}, {1, 0}, {1, 1}, {1, 2}
		},
		// ___
		//    |
		{
			{0, 0}, {0, 1}, {0, 2}, {1, 2}
		},
		//  ___
		// |
		{
			{0, 0}, {0, 1}, {0, 2}, {1, 0}
		}
	};
	
	static int[][] arr;
	static int N, M;
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int sum(int tetNo, int y, int x) {
		int r = 0;
		for (int j = 0; j < 4; j++) {
			int ny = y + tet[tetNo][j][0];
			int nx = x + tet[tetNo][j][1];
			if (!inrange(ny, nx)) return 0;
			r += arr[ny][nx];
		}
		return r;
	}
	
	public static void main(String[] args) {
		// N 4 2
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int r = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < tet.length; k++) {
					r = Math.max(r, sum(k, i, j));
				}
			}
		}
		System.out.println(r);
	}

}
