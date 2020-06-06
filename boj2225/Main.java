package boj2225;

import java.util.Scanner;

public class Main {
	
	static int[][] d = new int[201][201];
	static int MOD = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 0; i <= N; i++) d[i][1] = 1;
		
		for (int i = 0; i <= N; i++) {
			for (int j = 2; j <= K; j++) {				
				for (int k = 0; k <= i; k++) {
					d[i][j] += d[i - k][j - 1];
					d[i][j] %= MOD;
				}
			}
		}
		
		System.out.println(d[N][K]);
		
	}
	
}
