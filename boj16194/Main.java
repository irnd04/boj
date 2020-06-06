package boj16194;

import java.util.Scanner;

public class Main {
	
	static int[] d;
	static int[] arr;
	
	static int solve(int n) {
		if (n == 0) return 0;
		if (d[n] != -1) return d[n];
		int max = arr[n];
		for (int i = 1 ; i < n ; i++)
			max = Math.min(max, solve(n - i) + arr[i]);
		d[n] = max;
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N + 1];
		d = new int[N + 1];
		for (int i = 1; i <= N; i++) { arr[i] = sc.nextInt(); d[i] = -1; }
		System.out.println(solve(N));
		
	}
}
