package boj1963;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.Scanner;


// https://www.acmicpc.net/problem/1963
// 소수경로
// 간단한 bfs문제
// 에라토스테네스의 체를 사용하여 소수를 구해놓고 시작

public class Main {
	
	static boolean[] visit = new boolean[10000];
	static boolean[] prime = new boolean[10000];
	static int[] dist = new int[10000];
	
	static int B, E;
	
	static void makeprime() {
		for (int i = 2; i < 10000; i++) {
			if (!visit[i]) {
				prime[i] = true;
				for (int j = i + i; j < 10000; j += i) 
					visit[j] = true;
			}
		}
	}
	
	static int toint(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum *= 10;
			sum += arr[i];
		}
		return sum;
	}
	
	static int[] toarr(int x) {
		int[] r = new int[4];
		for (int i = 3; i >= 0; i--) {
			r[i] = x % 10;
			x /= 10;
		}
		return r;
	}
	
	static void bfs() {
		Arrays.fill(dist, -1);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(B);
		dist[B] = 0;
		int cur;
		int bef;
		int x;
		int[] arr;
		while (!q.isEmpty()) {
			
			cur = q.poll();
			arr = toarr(cur);
			
			if (cur == E) return;
			
			for (int i = 0; i < 4; i++) {
				bef = arr[i];
				for (int j = 0; j <= 9; j++) {
					arr[i] = j;
					x = toint(arr);
					if (x < 1000) continue;
					if (!prime[x]) continue;
					if (dist[x] != -1) continue;
					dist[x] = dist[cur] + 1;
					q.offer(x);
				}
				arr[i] = bef;
			}
		}
		
	}
	
	public static void main(String[] args) {
		makeprime();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			B = sc.nextInt();
			E = sc.nextInt();
			bfs();
			System.out.println(dist[E] == -1 ? "Impossible" : dist[E]);
		}
	}
}
