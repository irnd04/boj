package boj12015;

import java.util.Scanner;

/*
 *
가장 긴 증가하는 부분 수열 2
https://www.acmicpc.net/problem/12015
i번째 숫자를 봤을때
res배열에는 index + 1 의 길이의 부분증가수열의 마지막수의 최솟값이 담긴다.
 */

public class Main {
	
	static int N;
	static int[] inp;
	static int[] res;
	static int rdx = -1;
	
	static int lowerBound(int lo, int hi, int x) {
		if (lo == hi) return hi;
		int mid = (lo + hi) / 2;
		if (res[mid] < x)
			return lowerBound(mid + 1, hi, x);
		return lowerBound(lo, mid, x);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N];
		res = new int[N];
		for (int i = 0; i < N; i++) inp[i] = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int r = lowerBound(0, rdx + 1, inp[i]);
			if (r > rdx) rdx = r;
			res[r] = inp[i];
		}
		System.out.println(rdx + 1);
	}
}

/*
6
10 20 10 30 20 50
*/