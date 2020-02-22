package boj1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
10
10 -4 3 1 5 6 -35 12 21 -1
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		d = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			d[i] = arr[i];
		}
		for (int i = 1; i < N; i++) d[i] = Math.max(arr[i], d[i - 1] + arr[i]);
		int max = d[0];
		for (int i = 0; i < N; i++)
			max = Math.max(max, d[i]);
		System.out.println(max);
	}
}
