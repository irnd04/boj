package boj1080;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1080
// 행렬

// 어떤 똑같은 3*3칸을 두번이상바꾸는건 의미가 없다.
// 어떤 다른 3*3칸을 어떤 순서대로 바꾸던지 항상같다.
// (0,0)의 칸을 바꾸기위해서는 단 하나의 3*3칸만 가능하다.
// (0,0)칸을 바꾼이후 (0,1)칸은 단하나의 3*3칸만 바꿀수 있다
// 반복..

public class Main {
	
	static char[][] q;
	static char[][] a;
	static char togg = '0' + '1';
	static int N;
	static int M;
	
	static void toggle(int y, int x) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				q[i][j] = (char) (togg - q[i][j]);
			}
		}
	}
	
	static void printarr(char[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean eq() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (q[i][j] != a[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		q = new char[N][M];
		a = new char[N][M];
		int r = 0;
		
		for (int i = 0; i < N; i++) q[i] = sc.next().toCharArray();
		for (int i = 0; i < N; i++) a[i] = sc.next().toCharArray();
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (q[i][j] != a[i][j]) {
					toggle(i, j);
					r++;
				}
			}
		}
		
		System.out.println(eq() ? r : -1);
		
	}
	
}

/*
3 4
0000
0010
0000
1001
1011
1001
*/