package boj16949;

import java.util.Scanner;
import java.util.TreeSet;


// https://www.acmicpc.net/problem/16946
// �� �μ��� �̵��ϱ� 4
// dfs �ð����⵵ O(NM)
// ��� ��ǥ�� ���� dfs�� �ؾ��ϴ� O(NMNM)
// N�� M�� ������ 1000�̹Ƿ� �ð��� �ʹ� �����ɸ���.
// 0������ �̹� �׷쿡���� ����� ���ϰ� 1�� �����ִ� �׷��� ����ΰ��� ���캸�°����� �ذ��� �����ϴ�. 

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