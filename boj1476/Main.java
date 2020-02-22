package boj1476;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int a, b, c, r;
		a = b = c = r = 1;
		while (true) {
			if (a == e && b == s && c == m) break;
			a++; b++; c++; r++;
			if (a == 16) a = 1;
			if (b == 29) b = 1;
			if (c == 20) c = 1;
		}
		System.out.println(r);
	}
}
