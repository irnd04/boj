package boj11057;

import java.util.Scanner;

public class Main {
	
	static int MOD = 10007;
	static int[][] d = new int[1001][10];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i <= 9; i++) d[1][i] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k <= 9; k++) {
					d[i][j] += d[i - 1][k];
					d[i][j] %= MOD;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i <= 9; i++) sum += d[N][i];
		System.out.println(sum % MOD);
		
	}
}
