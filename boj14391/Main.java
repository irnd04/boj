package boj14391;

import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	static void set(int[] arr, int i, int j, int v) {
		arr[i * M + j] = v;
	}
	
	static int get(int[] arr, int i, int j) {
		return arr[i * M + j];
	}
	
	static void printset(int set) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int idx = i * M + j;
				if ((set & (1 << idx)) > 0)
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
		}
	}
	
	static int ga(int set) {
		int sum = 0;
		int idx;
		int mul = 1, r = 0;
		for (int i = 0; i < N; i++) {
			r = 0;
			mul = 1;
			for (int j = M - 1; j >= 0; j--) {
				idx = i * M + j;
				if ((set & (1 << idx)) == 0) {
					r += get(arr, i, j) * mul;
					mul *= 10;
				} else {
					sum += r;
					mul = 1;
					r = 0;
				}
			}
			sum += r;
		}
		return sum;
	}
	
	static int se(int set) {
		int sum = 0;
		int idx;
		int r = 0, mul = 1;
		for (int i = 0; i < M; i++) {
			mul = 1;
			r = 0;
			for (int j = N - 1; j >= 0; j--) {
				idx = j * M + i;
				if ((set & (1 << idx)) > 0) {
					r += get(arr, j, i) * mul;
					mul *= 10;
				} else {
					sum += r;
					mul = 1;
					r = 0;
				}
			}
			sum += r;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N * M];
		char[] chars;
		for (int i = 0; i < N; i++) {
			chars = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				set(arr, i, j, chars[j] - '0');
			}
		}
		for (int i = 0; i < (1 << (N * M)); i++) {
			// 0   가로
			// !0 세로
			max = Math.max(ga(i) + se(i), max);
		}
		System.out.println(max);
	}
}

/*
4 4
1000
0001
0000
1000
*/