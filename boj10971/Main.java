package boj10971;

import java.util.Arrays;
import java.util.Scanner;
	
public class Main {
	
	static int N;
	static int visit;
	static int[][] m;
	static int[] arr;
	static int z = Integer.MAX_VALUE;
	
	static void perm(int p) {
		if (p == N) {
			int sum = 0;
			int cost;
			for (int i = 0; i < N - 1; i++) {
				cost = m[arr[i]][arr[i + 1]];
				sum += cost;
			}
			cost = m[arr[N - 1]][arr[0]];
			if (cost == 0) return;
			sum += cost;
			z = Math.min(z, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) > 0) continue;
			if (p != 0 && m[arr[p - 1]][i] == 0) continue;
			visit = visit | (1 << i);
			arr[p] = i;
			perm(p + 1);
			visit = visit & ~(1 << i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		m = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		arr[0] = 0;
		visit = visit | (1 << 0);
		perm(1);
		System.out.println(z);
	}
}
