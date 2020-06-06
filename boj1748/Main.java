package boj1748;

import java.util.Scanner;

public class Main {
	
	static long solve(int n) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += String.valueOf(i).length();
		}
		return sum;
	}
	
	static long solve2(int n) {
		int c = 0;
		long sum = 0;
		for (int i = 1; i <= n; i *= 10) {
			c++;
			String e = "";
			for (int j = 0; j < String.valueOf(i).length(); j++) e += 9;
			int end = Integer.parseInt(e);
			if (i * 10 > n) end = n;
			sum += (end - i + 1) * c;
		}
		return sum;
	}

	public static void main(String[] args) {
		// end - start + 1
		// 999 - 100 + 1
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(solve2(N));
		
	}
	
}
