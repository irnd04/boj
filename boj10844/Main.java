package boj10844;

import java.util.Scanner;

public class Main {
	
	static int MOD = 1000000000;
	static int[][] d = new int[101][11];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= 9; i++) d[1][i] = 1;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j - 1 >= 0) {
					d[i][j] += d[i - 1][j - 1];	
					d[i][j] %= MOD;
				}
				if (j + 1 <= 9) {
					d[i][j] += d[i - 1][j + 1];
					d[i][j] %= MOD;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += d[N][i];
			sum %= MOD;
		}
		System.out.println(sum);
	}
	
}
