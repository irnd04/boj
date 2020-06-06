package boj14442;

import java.util.LinkedList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14442
// �� �μ��� �̵��ϱ�2
// �� �μ��� �̵��ϱ�1�� ����
// ���� ����μ��������� üũ�Ͽ� dist�迭�� ���

class Node {
	int y;
	int x;
	int broken;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", broken=" + broken + "]";
	}
	public Node(int y, int x, int broken) {
		super();
		this.y = y;
		this.x = x;
		this.broken = broken;
	}	
}

public class Main {
	
	static int N, M, K;
	static int[][] inp = new int[1000][1000];
	static int[][][] dist = new int[1000][1000][11];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int bfs() {
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur;
		dist[0][0][0] = 1;
		q.offer(new Node(0, 0, 0));
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			
			if (cur.y == N - 1 && cur.x == M - 1) return dist[cur.y][cur.x][cur.broken];
			
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (inp[ny][nx] == 0 && dist[ny][nx][cur.broken] == -1) {
					dist[ny][nx][cur.broken] = dist[cur.y][cur.x][cur.broken] + 1;
					q.offer(new Node(ny, nx, cur.broken));
				}
				
				if (inp[ny][nx] == 1 && cur.broken < K && dist[ny][nx][cur.broken + 1] == -1) {
					dist[ny][nx][cur.broken + 1] = dist[cur.y][cur.x][cur.broken] + 1;
					q.offer(new Node(ny, nx, cur.broken + 1));
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		char[] chs;
		for (int i = 0; i < N; i++) {
			chs = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				inp[i][j] = chs[j] - '0';
				for (int k = 0; k <= K; k++) dist[i][j][k] = -1;
			}
		}
		System.out.println(bfs());
	}
}
/*
6 4 1
0100
1110
1000
0000
0111
0000
*/