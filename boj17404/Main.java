package boj17404;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[][] d = new int[1001][3];
	static int[][] a = new int[1001][3];
	static int INF = 1000 * 1000 + 1;
	static int N;
	
	static int[][] pos = {
			{1, 2},
			{0, 2},
			{0, 1}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 0 R 
		// 1 G
		// 2 B
		int r = INF;
		
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int s = 0; s < 3; s++) {
			for (int i = 0; i < 3; i++) d[0][i] = a[0][i];
			for (int color : pos[s]) d[0][color] = INF;
			for (int i = 1; i < N; i++) {
				d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
				d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
				d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
			}
			int min = INF;
			for (int color : pos[s]) min = Math.min(d[N - 1][color], min);
			r = Math.min(min, r);
		}		
		System.out.println(r);
	}
}
