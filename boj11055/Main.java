package boj11055;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] a;
	static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		d = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = d[i] = sc.nextInt();
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i])
					d[i] = Math.max(d[i], d[j] + a[i]);
			}
		}
		
		int r = d[0];
		for (int i = 0; i < N; i++)
			r = Math.max(r, d[i]);
		System.out.println(r);
		
	}
}
