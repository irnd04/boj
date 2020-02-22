package boj2352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int MAX = 40000;
	static int[] arr = new int[MAX];
	static int[] input = new int[MAX];
	static int N;
	
	static int solve(int n) {
		if (arr[n] != -1) return arr[n];
		int max = 1;
		for (int i = n; i >= 0; i--) {
			if (input[n] > input[i]) {
				max = Math.max(max, solve(i) + 1);
			}
		}
		arr[n] = max;
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) arr[i] = -1;
		int max = 1;
		for (int i = 0; i < N; i++) 
			max = Math.max(max, solve(i));
		System.out.println(max);
	}
	
}
