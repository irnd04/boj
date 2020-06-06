package boj1248;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	static char[] str;
	static int c = 0;
	static int[][] ex = new int[10][2];
	
	static void solve(int p) {
		
		if (p == N) {
			for (int i = 0; i < N; i++)
				System.out.print(arr[i] + " ");
			System.exit(0);
		}
		
		int a, b;
		for (int i = -10; i <= 10; i++) {
			int exi = 0;
			for (int j = 0; j <= p; j++) {
				a = p; b = i;
				for (int k = 1; k <= j; k++) a += N - k;
				for (int k = j; k < p; k++) b += arr[k];
				ex[exi][0] = a;
				ex[exi++][1] = b;
			}
			
			boolean flag = false;
			for (int j = 0; j < exi; j++) {
				if (str[ex[j][0]] == '-' && ex[j][1] >= 0) { flag = true; break; }
				if (str[ex[j][0]] == '+' && ex[j][1] <= 0) { flag = true; break; }
				if (str[ex[j][0]] == '0' && ex[j][1] != 0) { flag = true; break; }	
			}
			if (flag) continue;
			arr[p] = i;
			solve(p + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		str = sc.next().toCharArray();
		solve(0);
		/*
4
-+0++++--+
*/
	}
	
}
