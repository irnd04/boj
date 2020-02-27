package boj2138;

import java.util.Scanner;


//https://www.acmicpc.net/problem/2138
// ������ ����ġ

// 0�� �ڸ��� N - 1�ڸ��� �����°��� �����Ѵٸ�

// � �Ȱ��� ��������ġ�� �ι��̻󴩸��°� �ǹ̰� ����.
// � �ٸ� ��������ġĭ�� � ������� �ٲٴ��� ����� �׻󰰴�.
// 0ĭ�� �ٲٱ����ؼ��� �� �ϳ��� ����ġ�� �����ϴ�.
// 0ĭ�� �ٲ����� 1ĭ�� ���ϳ��� ����ġ�� �ٲܼ� �ִ�
// �ݺ�..

// 0���ڸ��� N - 1�� �ڸ��� ������Ǽ��� �����������Ŀ�
// ���� ����� �����Ͽ� ������� �������� Ȯ���Ѵ�.

public class Main {
	
	static int N;
	static char[] q;
	static char[] q2;
	static char[] a;
	
	static int togg = '0' + '1';
	
	static void toggle(int x) {
		for (int i = x - 1; i <= x + 1; i++) {
			q[i] = (char) (togg - q[i]);
		}
	}
	
	static boolean eq() {
		for (int i = 0; i < N; i++)
			if (q[i] != a[i]) return false;
		return true;
	}
	
	static void left() {
		q[0] = (char) (togg - q[0]);
		q[1] = (char) (togg - q[1]);
	}
	
	static void right() {
		q[N - 1] = (char) (togg - q[N - 1]);
		q[N - 2] = (char) (togg - q[N - 2]);
	}
	
	static int run() {
		int c = 0;
		for (int i = 1; i < N - 1; i++) {
			if (q[i - 1] != a[i - 1]) {
				toggle(i);
				c++;
			}
		}
		return c;
	}
	
	static void copy(char[] a, char[] b)  {
		for (int i = 0; i < N; i++)
			a[i] = b[i];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		q = sc.next().toCharArray();
		q2 = new char[N];
		copy(q2, q);
		a = sc.next().toCharArray();
		
		boolean[][] perm = new boolean[][] {
			{false, false},
			{true, false},
			{false, true},
			{true, true}
		};
		int c;
		for (int i = 0; i < perm.length; i++) {
			copy(q, q2);
			c = 0;
			if (perm[i][0]) {
				left();
				c++;
			}
			if (perm[i][1]) {
				right();
				c++;
			} 
			c += run();
			if (eq()) {
				System.out.println(c);
				return;
			}
		}
		System.out.println(-1);
	}
}
