package boj12886;

import java.util.Scanner;

// 12886 ���׷�
// ���� ������ ���� ���� X, ū ���� Y��� ���Ѵ�. �� ����, X�� �ִ� ���� ������ X+X����, Y�� �ִ� ���� ������ Y-X���� �����.
// ���� ��� ����� ���� ABC�� ������ ����
// �׷��Ƿ� A�� B�� �˸� C�� �˼��ִ�.
// �ʿ��� ���� 1000 * 1000

public class Main {
	
	static int sum;
	
	static boolean[][] chk = new boolean[1001][1001];
	static boolean found;
	
	static boolean inrange(int a, int b, int c) {
		return a <= 1000 && b <= 1000 && c <= 1000;
	}
	
	static int[] step(int a, int b) {
		if (a == b) return null;
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		return new int[] {a - b, b + b};
	}
	
	static void dfs(int a, int b) {
		int c = sum - a - b;
		
		if (a == b && a == c) {
			found = true;
			return;
		}
		
		if (chk[a][b]) return;
		chk[a][b] = true;
		
		int[] r;
		
		r = step(a, b);
		if (r != null && inrange(r[0], r[1], c))
			dfs(r[0], r[1]);
		r = step(a, c);
		if (r != null && inrange(r[0], r[1], b))
			dfs(r[0], r[1]);
		r = step(b, c);
		if (r != null && inrange(r[0], r[1], a))
			dfs(r[0], r[1]);
	}
	
	public static void main(String[] args) {
		int A, B, C;
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		sum = A + B + C;
		dfs(A, B);
		System.out.println(found ? 1 : 0);
	}
	
}
