package boj1759;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
4 6
a t c i s w
 */

public class Main {
	
	static int N, M;
	static char[] arr;
	static char[] c;
	static List<Character> mo = Arrays.asList('a', 'e', 'i', 'o', 'u');
	
	static void comb(int p, int s) {
		if (p == M) {
			int moc, jac;
			moc = jac = 0;
			for (int i = 0; i < M; i++) {
				if (mo.contains(c[i])) moc++;
				else jac++;
			}
			if (jac >= 2 && moc >= 1)
				System.out.println(String.valueOf(c));
			return;
		}
		for (int i = s; i < N; i++) {
			c[p] = arr[i];
			comb(p + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		c = new char[M];
		arr = new char[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.next().charAt(0);
		Arrays.sort(arr);
		comb(0, 0);
	}
	
	
	

}
