package boj14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] d;
	static int[] arr;
	static int[] t;
	
	static void printtrace(int go) {
		if (go != t[go]) printtrace(t[go]);
		System.out.print(arr[go] + " ");
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
6
10 20 10 30 20 50
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		d = new int[N];
		t = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			t[i] = i;
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (d[i] < d[j] + 1) {
						d[i] = d[j] + 1;
						t[i] = j;
					}
				}
			}
		}
		int max = d[0];
		int s = 0;
		for (int i = 0; i < N; i++) {
			if (max < d[i]) {
				max = d[i];
				s = i;
			}
		}
		System.out.println(max);
		printtrace(s);
	}
}

