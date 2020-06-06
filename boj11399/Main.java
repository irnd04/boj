package boj11399;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11399
// ATM
// 설명생략

public class Main {
	
	static int N;
	static int[] arr;
	static int[] sum;
	static int total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		sum = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		sum[0] = arr[0];
		total += sum[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
			total += sum[i];
		}
		System.out.println(total);
	}
}
