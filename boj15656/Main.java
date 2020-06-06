package boj15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] input;
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
		for (int i = 0; i < N; i++) {
			arr[p] = input[i];
			solve(p + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		arr = new int[M];
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		Arrays.sort(input);
		solve(0);
		System.out.print(sb.toString());
	}
	
}
