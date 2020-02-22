package boj3085;

import java.util.Scanner;

/*
3
ABC
ABD
ZJK
 */

public class Main {
	
	static char[][] arr;
	static int N;
	
	static int[] dy = {0, 1};
	static int[] dx = {1, 0};
	
	static void printarr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
			
	}
	
	static boolean inrange(int r, int c) {
		return Math.min(r, c) >= 0 && Math.max(r, c) < N;
	}
	
	static void swap(int r1, int c1, int r2, int c2) {
		char temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}
	
	static int max() {
		char r, c;
		int rsum, rmax = -1;
		int csum, cmax = -1;
		for (int i = 0; i < N; i++) {
			r = arr[i][0];
			c = arr[0][i];
			rsum = 0;
			csum = 0;
			for (int j = 0; j < N; j++) {
				
				if (c == arr[j][i]) csum++;
				else {
					cmax = Math.max(csum, cmax);
					csum = 1;
					c = arr[j][i];
				}
				if (r == arr[i][j]) rsum++;
				else {
					rmax = Math.max(rsum, rmax);
					rsum = 1;
					r = arr[i][j];	 
				}
			}
			rmax = Math.max(rmax, rsum);
			cmax = Math.max(cmax, csum);
		}
		
		return Math.max(rmax, cmax);
	}
	
	public static void main(String[] args) {
		int max = -1;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			arr[i] = s.toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (inrange(ny, nx) && arr[ny][nx] != arr[i][j]) {
						swap(i, j, ny, nx);
						max = Math.max(max, max());
						swap(i, j, ny, nx);
					}
				}
			}
		}
		System.out.println(max);
	}
}
