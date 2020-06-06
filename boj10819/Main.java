package boj10819;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int chk;
	static int N;
	static int[] arr;
	static int[] r;
	static int z = -100000;
	
	static void printbin(int chk) {
		String s = "printbin :: ";
		for (int i = 0; i < N; i++) {
			s += String.format("%s:%s, ", i, chk & (1 << i));
		}
		System.out.println(s);
	}
	
	static void perm(int p) {
		
		if (p == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++)
				sum += Math.abs(r[i] - r[i + 1]);
			z = Math.max(z, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// chk
			if ((chk & (1 << i)) > 0) continue;
			// add
			chk = chk | (1 << i);
			r[p] = arr[i];
			perm(p + 1);
			// rem
			chk = chk & ~(1 << i);
		}
	}
	
	public static void main(String[] args) {
		
		/*
6
20 1 15 8 4 10
		*/
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		r = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		perm(0);
		System.out.println(z);
		
	}
	
}
