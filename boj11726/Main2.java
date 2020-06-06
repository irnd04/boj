package boj11726;

import java.util.Scanner;

public class Main2 {
	
	static int[] d = new int[1001];
	static int MOD = 10007;
	
	static int solve(int n) {
		if (n == 1 || n == 2) return n;
		if (d[n] != 0) return d[n];
		d[n] = solve(n - 1) + solve(n - 2);
		d[n] %= MOD;
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(solve(N));
	}
}
