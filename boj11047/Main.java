package boj11047;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11047
// 동전 0
// 그리디문제

public class Main {
	
	static int N, K;
	static int[] coin;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		coin = new int[N];
		for (int i = N - 1; i >= 0; i--) 
			coin[i] = sc.nextInt();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += K / coin[i];
			K %= coin[i];
		}
		System.out.println(sum);
	}
}
