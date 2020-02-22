package boj16198;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> li = new ArrayList<Integer>();
	static int N;
	
	static long solve(int n) {
		if (n == 2) return 0;
		int e, v;
		long max = 0;
		for (int i = 1; i < n - 1; i++) {
			e = li.get(i - 1) * li.get(i + 1);
			v = li.remove(i);
			max = Math.max(max, e + solve(n - 1));
			li.add(i, v);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) li.add(sc.nextInt());
		long r = solve(N);
		System.out.println(r);
//		int z = list.remove(3);
//		list.add(3, z);
	}
}
/*
4
1 2 3 4
*/