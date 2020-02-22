package boj11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] d;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
6
10 20 10 30 20 50
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		d = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					d[i] = Math.max(d[i], d[j] + 1);
			}
		}
		int max = d[0];
		for (int i = 0; i < N; i++)
			max = Math.max(d[i], max);
		System.out.println(max);
	}
}
