package boj14888;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 0 +
	// 1 -
	// 2 *
	// 3 /
	
	static int N, M;
	static int[] num;
	static int[] oper;
	static int[] ans;
	static boolean[] chk;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	static void perm(int p) {
		if (p == M) {
			int r = num[0];
			for (int i = 1; i < N; i++) {
				switch (ans[i - 1]) {
				case 0:
					r += num[i];
					break;
				case 1:
					r -= num[i];
					break;
				case 2:
					r *= num[i];
					break;
				case 3:
					r /= num[i];
					break;
				default:
					break;
				}
			}
			max = Math.max(max, r);
			min = Math.min(min, r);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (chk[i]) continue;
			chk[i] = true;
			ans[p] = oper[i];
			perm(p + 1);
			chk[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N - 1;
		num = new int[N];
		oper = new int[4 * N + 1];
		ans = new int[M];
		chk = new boolean[M];
		int operi = 0;
		for (int i = 0; i < N; i++) num[i] = sc.nextInt();
		for (int i = 0; i < 4; i++) {
			int z = sc.nextInt();
			for (int j = 0; j < z; j++) {
				oper[operi++] = i;
			}
		}
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}
}

/*
2
5 6
0 0 1 0
*/