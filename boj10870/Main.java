package boj10870;

import java.util.Scanner;

public class Main {
	
	static int fibo(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}
}
