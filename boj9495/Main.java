package boj9495;

import java.util.Scanner;

public class Main {
	
	static int[][] d = new int[100001][3];
	static int[][] a = new int[2][100001];
	
	public static void main(String[] args) {
		
		// 0 À§ ¶âÀ½
		// 1 ¾Æ·¡ ¶âÀ½
		// 2 ¾È ¶âÀ½
		
		/*
3
100 0 0
0 50 100
		*/
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int N = sc.nextInt();
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			d[1][0] = a[0][1]; // À§
			d[1][1] = a[1][1]; // ¾Æ·¡ 
			d[1][2] = 0;       // ¾È¶âÀ½
			
			for (int i = 2; i <= N; i++) {
				d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]) + a[0][i];
				d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + a[1][i];
				d[i][2] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
			}
			int max = d[N][0];
			for (int i = 0; i < 3; i++) max = Math.max(max, d[N][i]);
			System.out.println(max);
		}
	}
}
