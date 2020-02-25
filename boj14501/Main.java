package boj14501;

import java.util.Scanner;

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */

public class Main {
	
	static int N;
	static int[] T;
	static int[] P;
	
	static int solve(int day) {
		if (day == N + 1) return 0;
		int max = solve(day + 1);
		if (day + T[day] <= N + 1)
			max = Math.max(solve(day + T[day]) + P[day], max);
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		System.out.println(solve(1));
	}
	
}
