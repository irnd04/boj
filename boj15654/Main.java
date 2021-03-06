package boj15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] input;
	static boolean[] chk;
	
	static void solve(int p) {
		if (p == M) {
			for (int i = 0; i < M; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (chk[i]) continue;
			chk[i] = true;
			arr[p] = input[i];
			solve(p + 1);
			chk[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		chk = new boolean[N];
		arr = new int[M];
		for (int i = 0; i < N; i++) input[i] = sc.nextInt();
		Arrays.sort(input);
		solve(0);
	}
	
}
