package boj15658;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] inp;
	static int[] res;
	static int[] oper = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void comb(int p) {
		
		if (p == M) {
			int r = inp[0];
			for (int i = 1; i < N; i++) {
				switch (res[i - 1]) {
				case 0:
					r += inp[i];
					break;
				case 1:
					r -= inp[i];
					break;
				case 2:
					r *= inp[i];
					break;
				case 3:
					r /= inp[i];
					break;
				default:
					break;
				}
			}
			max = Math.max(max, r);
			min = Math.min(min, r);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (oper[i] == 0) continue;
			oper[i]--;
			res[p] = i;
			comb(p + 1);
			oper[i]++;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N - 1;
		inp = new int[N];
		res = new int[M];
		for (int i = 0; i < N; i++)
			inp[i] = sc.nextInt();
		for (int i = 0; i < 4; i++)
			oper[i] = sc.nextInt();
		comb(0);
		System.out.println(max);
		System.out.println(min);
	}
}
/*
2
5 6
1 1 1 1
*/