package boj1182;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int r;
	static int[] ans;
	static int[] input;
	static boolean first = true;
	static int c;
	
	static void comb2(int p) {
		if (p == N) {
			if (first) { first = false; return; } // 공집합처리 모든것이 0으로 이루어짐
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (ans[i] == 1) sum += input[i];
			}
			if (sum == r) c++;
			return;
		}
		ans[p] = 0;
		comb2(p + 1);
		ans[p] = 1;
		comb2(p + 1);
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = new int[N];
		input = new int[N];
		r = sc.nextInt();
		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();
		comb2(0);
		System.out.println(c);
	}
}
/*
5 0
-7 -3 -2 5 8

*/