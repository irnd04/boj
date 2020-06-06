package boj15664;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] input;
	static int[] arr;
	static boolean[] chk;
	static HashSet<String> set = new HashSet<String>();
	
	static void solve(int p, int s) {
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
		for (int i = s; i < N; i++) {
			arr[p] = input[i];
			solve(p + 1, i + 1);
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
		solve(0, 0);
	}
}
