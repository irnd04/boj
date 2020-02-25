package boj6603;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] S = new int[13];
	static int[] r = new int[6];
	static int N;
	static StringBuilder sb;
	
	static void comb(int p, int s) {
		if (p == 6) {
			for (int i = 0; i < 6; i++) { sb.append(r[i]); sb.append(' '); }
			sb.append('\n');
			return;
		}
		
		for (int i = s; i < N; i++) {
			r[p] = S[i];
			comb(p + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			if (N == 0) break;
			for (int i = 0; i < N; i++) S[i] = sc.nextInt();
			sb = new StringBuilder();
			comb(0, 0);
			System.out.println(sb.toString());
		}
		
	}
}
/*
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
*/