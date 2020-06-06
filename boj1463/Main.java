package boj1463;

import java.util.Scanner;

public class Main {
	
	static int[] d;
	
	static int solve(int n) {
		if (n == 1) return 0;
		if (d[n] != 0) return d[n];
		int r = Integer.MAX_VALUE;
		if (n % 3 == 0) r = Math.min(r, solve(n / 3) + 1);
		if (n % 2 == 0) r = Math.min(r, solve(n / 2) + 1);
		r = Math.min(r, solve(n - 1) + 1);
		d[n] = r;
		return r;
	}
	
	public static void main(String[] args) {
/*
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.		
 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new int[N + 1];
		int r = solve(N);
		System.out.println(r);
	}
}
