package boj2529;

import java.util.Scanner;

public class Main {
	
	static int N;
	static boolean[] chk = new boolean[10];
	static int[] arr;
	static char[] c;
	
	static long max = -1;
	static long min = Long.MAX_VALUE;
	
	static void solve(int p) {
		
		if (p == N + 1) {
			
			int mul = 1;
			long r = 0;
			for (int i = N; i >= 0; i--) {
				r += (long) arr[i] * mul;
				mul *= 10;
			}
			max = Math.max(r, max);
			min = Math.min(r, min);
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (chk[i]) continue;
			if (p != 0 && c[p - 1] == '<' && arr[p - 1] >= i) continue;
			if (p != 0 && c[p - 1] == '>' && arr[p - 1] <= i) continue;
			chk[i] = true;
			arr[p] = i;
			solve(p + 1);
			chk[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		c = new char[N];
		for (int i = 0; i < N; i++) c[i] = sc.next().charAt(0);
		solve(0);
		System.out.println(String.format("%0" + (N + 1) + "d", max));
		System.out.println(String.format("%0" + (N + 1) + "d", min));
	}
}
