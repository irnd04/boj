package boj17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
		}
		
		if (n == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		long g = gcd(arr[0], arr[1]);
		
		for (int i = 2; i < arr.length; i++) {
			g = gcd(g, arr[i]);
		}
		System.out.println(g);
	}
}
