package boj1149;

import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int[][] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][3];
		d = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 3; i++) d[0][i] = arr[0][i];
		for (int i = 1; i < N; i++) {
			// R
			d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]);
			d[i][0] += arr[i][0];
			// G
			d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]);
			d[i][1] += arr[i][1];
			// B
			d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]);
			d[i][2] += arr[i][2];
		}
		
		int min = d[N - 1][0];
		for (int i = 0; i < 3; i++) min = Math.min(d[N - 1][i], min);
		System.out.println(min);
	}
}
