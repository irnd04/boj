package boj1182;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int r;
	static int res;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					sum += arr[j];
				}
			}
			if (r == sum) res++; 
		}
		System.out.println(res);
	}
	
}
