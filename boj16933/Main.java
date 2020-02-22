package boj16933;

import java.util.LinkedList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/16933
// 벽 부수고 이동하기3
// 벽 부수고 이동하기1과 동일
// 벽을 몇번부수었는지도 체크하여 dist배열에 기록
// 낮인지 밤인지도 dist배열에 기록

class Node {
	int y;
	int x;
	int broken;
	int day;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", broken=" + broken + ", isday=" + day + "]";
	}
	public Node(int y, int x, int broken, int isday) {
		super();
		this.y = y;
		this.x = x;
		this.broken = broken;
		this.day = isday;
	}
}

public class Main {
	
	static int N, M, K;
	static int[][] inp = new int[1000][1000];
	static int[][][][] dist = new int[1000][1000][11][2];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int bfs() {
		LinkedList<Node> q = new LinkedList<Node>();
		Node cur;
		// 0 이 낮
		// 1 이 밤
		dist[0][0][0][0] = 1;
		q.offer(new Node(0, 0, 0, 0));
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			
			if (cur.y == N - 1 && cur.x == M - 1) return dist[cur.y][cur.x][cur.broken][cur.day];
			
			// 머무는경우
			if (dist[cur.y][cur.x][cur.broken][1 - cur.day] == -1) {
				dist[cur.y][cur.x][cur.broken][1 - cur.day] = dist[cur.y][cur.x][cur.broken][cur.day] + 1;
				q.offer(new Node(cur.y, cur.x, cur.broken, 1 - cur.day));
			}
			
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (inp[ny][nx] == 0 && dist[ny][nx][cur.broken][1 - cur.day] == -1) {
					dist[ny][nx][cur.broken][1 - cur.day] = dist[cur.y][cur.x][cur.broken][cur.day] + 1;
					q.offer(new Node(ny, nx, cur.broken, 1 - cur.day));
				}
				
				if (cur.day == 0 && inp[ny][nx] == 1 && cur.broken < K && dist[ny][nx][cur.broken + 1][1 - cur.day] == -1) {
					dist[ny][nx][cur.broken + 1][1 - cur.day] = dist[cur.y][cur.x][cur.broken][cur.day] + 1;
					q.offer(new Node(ny, nx, cur.broken + 1, 1 - cur.day));
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
				for (int k = 0; k <= K; k++) dist[i][j][k][0] = dist[i][j][k][1] = -1;
			}
		}
		System.out.println(bfs());
	}
}