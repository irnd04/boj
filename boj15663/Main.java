package boj15663;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] input;
	static int[] arr;
	static boolean[] chk;
	static HashSet<String> set = new HashSet<String>();
	
	static void solve(int p) {
		if (p == M) {
			String line = "";
			for (int i = 0; i < M; i++)
				line += arr[i] + " ";
			if (!set.contains(line)) {
				System.out.println(line);
				set.add(line);
			}
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
