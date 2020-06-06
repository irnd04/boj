package boj15990;

import java.util.Scanner;

public class Main {
	
	static final int MOD = 1000000009;
	static int[][] d = new int[100001][4];
	
	static int solve(int n, int l) {
		if (n == 1 && l == 1) return 1;
		if (n == 2 && l == 2) return 1;
		if (n == 3 && l == 1) return 1;
		if (n == 3 && l == 2) return 1;
		if (n == 3 && l == 3) return 1;	
		if (n <= 3) return 0;
		
		if (d[n][l] > 0) return d[n][l];
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			if (i == l) continue;
			sum += solve(n - l, i);
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
			for (int i = 1; i <= 3; i++) { r += solve(n, i); r %= MOD; }
			System.out.println(r);
		}
	}
}
