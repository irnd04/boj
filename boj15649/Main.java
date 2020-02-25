package boj15649;

import java.util.Scanner;

public class Main {
	
	static boolean[] chk;
	static int N;
	static int M;
	
	static void solve(int p, int[] arr) {
		
		if (p == M) {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (chk[i]) continue;
			chk[i] = true;
			arr[p] = i;
			solve(p + 1, arr);
			chk[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		chk = new boolean[N + 1];
		solve(0, new int[M]);
	}
	
}
