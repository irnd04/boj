package boj9095;

import java.util.Scanner;

public class Main {
	
	static int[] d = new int[100];
	
	static int solve(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		if (d[n] != 0) return d[n];
		d[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
		return d[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			int n = sc.nextInt();
			System.out.println(solve(n));
		}
	}
}
