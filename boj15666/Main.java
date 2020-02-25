package boj15666;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static Integer[] input;
	static int[] arr;
	static boolean[] chk;
	static HashSet<Integer> set = new HashSet<Integer>();
	
	static void solve(int p, int s) {
		if (p == M) {
			String line = "";
			for (int i = 0; i < M; i++)
				line += arr[i] + " ";
			System.out.println(line);
			return;
		}
		for (int i = s; i < N; i++) {
			arr[p] = input[i];
			solve(p + 1, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		for (int i = 0; i < N; i++) set.add(sc.nextInt());
		N = set.size();
		input = new ArrayList<Integer>(set).toArray(new Integer[N]);
		Arrays.sort(input);
		solve(0, 0);
	}
}
