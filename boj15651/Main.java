package boj15651;

import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	static void solve(int p) {
		if (p == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]);
				sb.append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[p] = i;
			solve(p + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		solve(0);
		System.out.println(sb.toString());
	}
}
