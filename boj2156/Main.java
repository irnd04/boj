package boj2156;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] d = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		if (N == 1) {
			System.out.println(arr[0]);
			return;
		}
		if (N == 2) {
			System.out.println(arr[0] + arr[1]);
			return;
		}
		
		d[0] = arr[0];
		d[1] = arr[0] + arr[1];
		d[2] = Math.max(Math.max(arr[0] + arr[2], d[1]), arr[1] + arr[2]);
		
		for (int i = 3; i < N; i++) {
			d[i] = Math.max(d[i - 3] + arr[i - 1] + arr[i], d[i - 2] + arr[i]);
			d[i] = Math.max(d[i - 1], d[i]);
		}
		
		System.out.println(d[N - 1]);
		
	}
	
}

/*
7
9
9
1
1
1
9
9

*/