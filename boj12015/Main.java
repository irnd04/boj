package boj12015;

import java.util.Scanner;

/*
 *
가장 긴 증가하는 부분 수열 2
https://www.acmicpc.net/problem/12015
i번째 숫자를 봤을때
res배열에는 index + 1 의 길이의 부분증가수열의 마지막수의 최솟값이 담긴다.
res가 갱신될때마다 prev에 이전 숫자의 인덱스를 기록하면 실제 부분수열을 구할 수 있다.

내 수준이상의 문제이다.
내가 이걸 몇일뒤에 푼다면 다시 풀 수 있을까?
 */

public class Main {
	
	static int N;
	static int[] inp;
	static int[] res;
	static int[] resi;
	static int[] prev;
	static int rdx = -1;
	
	static int lowerBound(int lo, int hi, int x) {
		if (lo == hi) return hi;
		int mid = (lo + hi) / 2;
		if (res[mid] < x)
			return lowerBound(mid + 1, hi, x);
		return lowerBound(lo, mid, x);
	}
	
	static void tracking(int x) {
		System.out.println(inp[x]);
		tracking(prev[x]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N];
		res = new int[N];
		resi = new int[N];
		prev = new int[N + 1];
		for (int i = 0; i < N; i++) inp[i] = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int r = lowerBound(0, rdx + 1, inp[i]);
			if (r > rdx) rdx = r;
			if (r > 0) prev[r] = resi[r - 1]; 
			res[r] = inp[i];
			resi[r] = i;
		}
		System.out.println(rdx + 1);
		
//		실제 부분수열 출력
//		StringBuilder sb = new StringBuilder();
//		for (int i = 1; i <= rdx; i++)
//			sb.append(inp[prev[i]] + " ");
//		sb.append(res[rdx] + " ");
//		System.out.println(sb.toString());
	}
}

/*
6
10 20 10 30 20 50

4
5 6 7 1
*/