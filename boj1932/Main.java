package boj1932;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[][] a;
	static int N;
	
	
	public static void main(String[] args) {
	/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
		*/
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				int max = a[i - 1][j];
				if (j - 1 >= 0) max = Math.max(max, a[i - 1][j - 1]);
				a[i][j] += max;
			}
		}
		int r = a[N - 1][0];
		for (int i = 0; i < N; i++) r = Math.max(r, a[N - 1][i]);
		System.out.println(r);
		
	}
}
