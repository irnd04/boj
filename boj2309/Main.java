package boj2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N = 9;
	static int M = 2;
	static int sum = 0;
	static int[] arr = new int[N];
	static int[] d = new int[M];
	static boolean flag = false;
	
	static void solve(int p, int s) {
		if (flag) return;
		if (p == M) {
			if (sum - (arr[d[0]] + arr[d[1]]) == 100) {
				flag = true;
				for (int i = 0; i < N; i++) {
					if (i == d[0] || i == d[1]) continue;
					System.out.println(arr[i]);
				}
			}
			return;
		}
		
		for (int i = s; i < N; i++) {
			d[p] = i;
			solve(p + 1, i + 1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		solve(0, 0);
	}
}
