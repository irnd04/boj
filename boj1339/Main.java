package boj1339;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static char[][] input;
	static boolean[] chk = new boolean[26];
	static HashSet<Integer> set = new HashSet<Integer>();
	static int[] chidx;
	static int[] value = new int[26];
	static int N;
	static int M;
	static int[] permarr;
	static int max = 0;
	
	public static void perm(int p) {
		if (p == M) {
			Arrays.fill(value, 0);
			int v = 9;
			for (int i = 0; i < permarr.length; i++)
				value[permarr[i]] = v--;
			
			int total = 0;
			int sum;
			int mul;
			for (int i = 0; i < input.length; i++) {
				mul = 1;
				sum = 0;
				for (int j = input[i].length - 1; j >= 0; j--) {
					int x = input[i][j] - 'A';
					sum += value[x] * mul;
					mul *= 10;
				}
				total += sum;
			}
			
			max = Math.max(total, max);
			return;
		}
		for (int i = 0; i < M; i++) {
			if (chk[chidx[i]]) continue;
			chk[chidx[i]] = true;
			permarr[p] = chidx[i];
			perm(p + 1);
			chk[chidx[i]] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new char[N][];
		for (int i = 0; i < N; i++) {
			input[i] = sc.next().toCharArray();
			for (int j = 0; j < input[i].length; j++) {
				set.add(input[i][j] - 'A');
			}
		}
		M = set.size();
		chidx = new int[M];
		permarr = new int[M];
		int ci = 0;
		for (int i : set) chidx[ci++] = i;
		perm(0);
		System.out.println(max);
	
	}
}
