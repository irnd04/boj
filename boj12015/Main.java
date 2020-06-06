package boj12015;

import java.util.Scanner;

/*
 *
���� �� �����ϴ� �κ� ���� 2
https://www.acmicpc.net/problem/12015
i��° ���ڸ� ������
res�迭���� index + 1 �� ������ �κ����������� ���������� �ּڰ��� ����.
res�� ���ŵɶ����� prev�� ���� ������ �ε����� ����ϸ� ���� �κм����� ���� �� �ִ�.

�� �����̻��� �����̴�.
���� �̰� ���ϵڿ� Ǭ�ٸ� �ٽ� Ǯ �� ������?
 */

public class Main {
	
	static int N;
	static int[] inp;
	static int[] res;
	static int[] resi;
	static int[] prev;
	static int rdx = -1;
	
	static int lowerBound(int lo, int hi, int x) {
		if (lo == hi) return hi;
		int mid = (lo + hi) / 2;
		if (res[mid] < x)
			return lowerBound(mid + 1, hi, x);
		return lowerBound(lo, mid, x);
	}
	
	static void tracking(int x) {
		System.out.println(inp[x]);
		tracking(prev[x]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N];
		res = new int[N];
		resi = new int[N];
		prev = new int[N + 1];
		for (int i = 0; i < N; i++) inp[i] = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int r = lowerBound(0, rdx + 1, inp[i]);
			if (r > rdx) rdx = r;
			if (r > 0) prev[r] = resi[r - 1]; 
			res[r] = inp[i];
			resi[r] = i;
		}
		System.out.println(rdx + 1);
		
//		���� �κм��� ���
//		StringBuilder sb = new StringBuilder();
//		for (int i = 1; i <= rdx; i++)
//			sb.append(inp[prev[i]] + " ");
//		sb.append(res[rdx] + " ");
//		System.out.println(sb.toString());
	}
}

/*
6
10 20 10 30 20 50

4
5 6 7 1
*/