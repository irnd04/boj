package boj14889_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	
	static int sum(ArrayList<Integer> l) {
		int sum = 0;
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < l.size(); j++) {
				sum += arr[l.get(i)][l.get(j)];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < (1 << N); i++) {
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			ArrayList<Integer> l2 = new ArrayList<Integer>();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) l1.add(j);
				else l2.add(j);
			}
			if (l1.size() != N / 2) continue;
			min = Math.min(Math.abs(sum(l1) - sum(l2)), min);
		}
		System.out.println(min);
	}
}
