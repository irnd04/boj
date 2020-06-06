package boj15650;

import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	static void solve(int p, int s) {
		if (p == M) {
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = s; i <= N; i++) {
			arr[p] = i;
			solve(p + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		solve(0, 1);
	}
	
}
