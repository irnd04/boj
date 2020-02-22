package boj14225_2;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] inp;
	static boolean[] chk = new boolean[100000 * 20 + 1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N];
		for (int i = 0; i < N; i++)
			inp[i] = sc.nextInt();
		for (int i = 0; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					sum += inp[j];
				}
			}
			chk[sum] = true;
		}
		
		for (int i = 1;; i++) {
			if (!chk[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}
/*
3
5 1 2
 */
