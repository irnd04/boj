package boj6064;

import java.util.Scanner;

public class Main {
	
	static int M, N;
	static int x, y;
	
	static long gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	static long lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
	
	static int solve() {
		int a, b, c;
		a = b = c = 1;
		long _lcm = lcm(M, N);
		
		// y ¸ÂÃß±â
		int add = y - b;
		b = b + add;
		a = a + add;
		c += add;
		
		a = a % M;
		if (a == 0) a = M;
		if (a == x) return c;
		
		while (c <= _lcm) {
			c += N;
			a += N;
			a %= M;
			if (a == 0) a = M;
			if (a == x) return c;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			System.out.println(solve());
		}
	}
}
