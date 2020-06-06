package boj11054;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] a;
	static int[] inc;
	static int[] dec;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N];
		inc = new int[N];
		dec = new int[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			inc[i] = dec[i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) inc[i] = Math.max(inc[i], inc[j] + 1);
			}
		}
		
		for (int i = N - 2; i >= 0; i--) {
			for (int j = i + 1; j < N; j++) {
				if (a[i] > a[j]) dec[i] = Math.max(dec[i], dec[j] + 1);
			}
		}
		
		int max = inc[0] + dec[0] - 1;
		for (int i = 0; i < N; i++)
			max = Math.max(max, inc[i] + dec[i] - 1);
		System.out.println(max);
		
		
	}
}
