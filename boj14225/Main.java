package boj14225;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] S;
	static int[] res;
	static HashSet<Integer> set = new HashSet<Integer>();
	
	static void perm(int p) {
		if (p == N) {
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				if (res[i] == 1)
					sum += S[i];
			}
			set.add(sum);
			return;
		}
		res[p] = 0;
		perm(p + 1);
		res[p] = 1;
		perm(p + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = new int[N];
		res = new int[N];
		for (int i = 0; i < N; i++)
			S[i] = sc.nextInt();
		perm(0);
		int r = 1;
		while (true) {
			if (!set.contains(r)) {
				System.out.println(r);
				break;
			}
			r++;
		}
	}
}

/*
3
5 1 2
*/