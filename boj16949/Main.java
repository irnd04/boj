package boj16949;

import java.util.Scanner;
import java.util.TreeSet;


// https://www.acmicpc.net/problem/16946
// 벽 부수고 이동하기 4
// dfs 시간복잡도 O(NM)
// 모든 좌표에 대해 dfs를 해야하니 O(NMNM)
// N과 M의 제한이 1000이므로 시간이 너무 오래걸린다.
// 0에대해 이미 그룹에대한 사이즈를 구하고 1이 갈수있는 그룹이 어디인가를 살펴보는것으로 해결이 가능하다. 

public class Main {
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int N, M;
	static int[][] inp = new int[1000][1000];
	static int[][] visit = new int[1000][1000];
	static int[] size = new int[1000001];
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int dfs(int y, int x, int v) {
		if (visit[y][x] == v) return 0;
		int c = 0;
		c++;
		visit[y][x] = v;
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (!inrange(ny, nx)) continue;
			if (inp[ny][nx] == 0)
				c += dfs(ny, nx, v);
		}
		return c;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) {
			char[] chs = sc.next().toCharArray();
			for (int j = 0; j < chs.length; j++) {
				inp[i][j] = chs[j] - '0';
			}
		}
		int id = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (inp[i][j] == 0 && visit[i][j] == 0) {
					++id;
					size[id] = dfs(i, j, id);
				}
					
			}
		}
		int ny, nx, r;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (inp[i][j] == 1) {
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int k = 0; k < 4; k++) {
						ny = i + dy[k];
						nx = j + dx[k];
						if (!inrange(ny, nx)) continue;
						set.add(visit[ny][nx]);
					}
					r = 1;
					for (int k : set)
						r += size[k];
					inp[i][j] = r % 10;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(inp[i][j]);
			}
			System.out.println();
		}
	}
}

/*
4 4
0 0 0 0
0 1 0 0
0 0 0 0
0 0 0 0
*/