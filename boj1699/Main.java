package boj1699;

import java.util.Scanner;

public class Main {
	
	static int[] d;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			d[i] = i;
			for (int j = 2; j * j <= i; j++) {
				d[i] = Math.min(d[i], d[i - j * j] + 1);
			}
		}
		System.out.println(d[N]);
	}
}
