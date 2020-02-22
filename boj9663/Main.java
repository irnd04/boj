package boj9663;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static boolean[] chklr = new boolean[30];
	static boolean[] chkrd = new boolean[30];
	static boolean[] chk = new boolean[15];
	static int[] res = new int[15];
	static int r; 
	
	static boolean lr(int y, int x) {
		return chklr[y + x];
	}
	
	static boolean rd(int y, int x) {
		return chkrd[y - x + N - 1];
	}
	
	static void perm(int p) {
		
		if (p == N) {
			r++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (chk[i]) continue;
			if (chklr[p + i]) continue;
			if (chkrd[i - p + N - 1]) continue;
			chk[i] = true;
			chklr[p + i] = true;
			chkrd[i - p + N - 1] = true;
			res[p] = i;
			perm(p + 1);
			chklr[p + i] = false;
			chkrd[i - p + N - 1] = false;
			chk[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		perm(0);
		System.out.println(r);
	}
	
}
