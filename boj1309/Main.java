package boj1309;

import java.util.Scanner;

public class Main {
	
	static int MOD = 9901;
	static int[][] d = new int[100001][3];
	
	public static void main(String[] args) {
		// 0 채우지않음
		// 1 왼쪽채움
		// 2 오른쪽채움
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		d[1][0] = d[1][1] = d[1][2] = 1;
		
		for (int i = 2; i <= N; i++) {
			d[i][0] = d[i - 1][0] + d[i - 1][1] + d[i - 1][2];
			d[i][0] %= MOD;
			d[i][1] = d[i - 1][0] + d[i - 1][2];
			d[i][1] %= MOD;
			d[i][2] = d[i - 1][0] + d[i - 1][1];
			d[i][2] %= MOD;
		}
		
		int sum = 0;
		for (int i = 0; i < 3; i++)
			sum += d[N][i];
		System.out.println(sum % MOD);
		
	}
}
