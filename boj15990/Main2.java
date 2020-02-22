package boj15990;

import java.util.Scanner;

public class Main2 {
	
	static final int MOD = 1000000009;
	static int[][] d = new int[100001][4];
	
	static int solve(int n, int l) {
		if (n == 0) return 1;
		if (d[n][l] > 0) return d[n][l];
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			if (l == i) continue;
			if (n - i < 0) continue;
			sum += solve(n - i, i);
			sum %= MOD;
		}
		d[n][l] = sum;
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int n = sc.nextInt();
			int r = 0;
			for (int i = 1; i <= 3; i++) { r += solve(n - i, i); r %= MOD; }
			System.out.println(r);
		}
	}
	
}
