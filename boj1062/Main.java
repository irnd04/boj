package boj1062;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int max = 0;
	static char[] res;
	static String[] strs;
	static char[] alpha = new char[] {
		'b', 'd', 'e', 'f', 'g', 'h',
		'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r',
		's', 'u', 'v', 'w', 'x', 'y', 'z'
	};
	
	static boolean chk(String str, char[] res) {
		for (int i = 0; i < str.length(); i++) {
			boolean f = false;
			for (int j = 0; j < M; j++) {
				if (str.charAt(i) == res[j]) {
					f = true;
					break;
				}
			}
			if (!f) return false;
		}
		return true;
	}
	
	public static void comb(int p, int s) {
		if (p == M) {
			int c = 0;
			for (int i = 0; i < N; i++) {
				if (chk(strs[i], res)) c++;
			}
			max = Math.max(max, c);
			return;
		}
		for (int i = s; i < alpha.length; i++) {
			res[p] = alpha[i];
			comb(p + 1, i + 1);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		res = new char[M];
		strs = new String[N];
		
		for (int i = 0; i < N; i++)
			strs[i] = sc.next();
		
		if (M < 5) {
			System.out.println(0);
			return;
		}
		
		res[0] = 'a';
		res[1] = 'n';
		res[2] = 't';
		res[3] = 'i';
		res[4] = 'c';
				
		comb(5, 0);
		System.out.println(max);
		
	}
}
/*
3 0
antarctica
antahellotica
antacartica
*/