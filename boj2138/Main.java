package boj2138;

import java.util.Scanner;


//https://www.acmicpc.net/problem/2138
// 전구와 스위치

// 0번 자리와 N - 1자리를 누르는것을 제외한다면

// 어떤 똑같은 전구스위치를 두번이상누르는건 의미가 없다.
// 어떤 다른 전구스위치칸을 어떤 순서대로 바꾸던지 결과는 항상같다.
// 0칸을 바꾸기위해서는 단 하나의 스위치만 가능하다.
// 0칸을 바꾼이후 1칸은 단하나의 스위치만 바꿀수 있다
// 반복..

// 0번자리와 N - 1번 자리의 모든경우의수를 먼저실행한후에
// 위의 방법을 실행하여 결과값이 나오는지 확인한다.

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
