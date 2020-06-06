package boj13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[]  a;
	static int[] d1;
	static int[] d2;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[N];
		d1 = new int[N];
		d2 = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			d1[i] = d2[i] = a[i];
		}
		// 끝나는..
		for (int i = 1; i < N; i++) {
			d1[i] = Math.max(d1[i - 1] + a[i], d1[i]);
		}
		// 시작하는..
		for (int i = N - 2; i >= 0; i--) {
			d2[i] = Math.max(d2[i + 1] + a[i], d2[i]);
		}
		
		int r = d1[0];
		for (int i = 0; i < N; i++) r = Math.max(d1[i], r);
		for (int i = 1; i < N - 1; i++) r = Math.max(d1[i - 1] + d2[i + 1], r);
		System.out.println(r);
	}
}
