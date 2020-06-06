package boj14889;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] t;
	static int[] c = new int[3];
	static int[][] score;
	static int R = Integer.MAX_VALUE;
	
	static int sum(ArrayList<Integer> l) {
		int r = 0;
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				r += score[l.get(i)][l.get(j)];
			}
		}
		return r;
	}
	
	static int chk() {
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (t[i] == 1) l1.add(i);
			if (t[i] == 2) l2.add(i);
		}
		return Math.abs(sum(l1) - sum(l2));
	}
	
	static void solve(int p) {
		
		if (c[1] > N / 2 || c[2] > N / 2) return;
		
		if (p == N) {
			R = Math.min(R, chk());
			return;
		}
		
		for (int i = 1; i <= 2; i++) {
			t[p] = i;
			c[i]++;
			solve(p + 1);
			c[i]--;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		t = new int[N];
		score = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				score[i][j] = sc.nextInt();
			}
		}
		solve(0);
		System.out.println(R);
	}
}
