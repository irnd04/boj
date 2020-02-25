package boj6087;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	int dir;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + ", dir=" + dir + "]";
	}
	public Node(int y, int x, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

public class Main {
	
	static int N;
	static int M;
	static char[][] inp;
	static int[][][] dist;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void printarr(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.printf("%4d", x[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && y < N && x < M;
	}
	
	static int bfs(int y, int x) {
		inp[y][x] = '*';
		LinkedList<Node> q = new LinkedList<Node>();
		for (int i = 0; i < 4; i++) {
			q.offer(new Node(y, x, i));
			dist[y][x][i] = 0;
		}
		Node cur;
		int ny, nx;
		int add;
		int min = 99999;
		while (!q.isEmpty()) {		
			cur = q.poll();
			if (inp[cur.y][cur.x] == 'C') {
				min = Math.min(dist[cur.y][cur.x][cur.dir], min);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (inp[ny][nx] == '*') continue;
				add = cur.dir == i ? 0 : 1;
				if (dist[ny][nx][i] == -1 || dist[ny][nx][i] > dist[cur.y][cur.x][cur.dir] + add) {
					dist[ny][nx][i] = dist[cur.y][cur.x][cur.dir] + add;
					q.offer(new Node(ny, nx, i));
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sy = 0, sx = 0;
		M = sc.nextInt();
		N = sc.nextInt();
		inp = new char[N][M];
		dist = new int[N][M][4];
		for (int i = 0; i < N; i++) {
			inp[i] = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++)
					dist[i][j][k] = -1;
				if (inp[i][j] == 'C') {
					sy = i; sx = j;
				}
			}
		}
		
		int r = bfs(sy, sx);
		System.out.println(r);
		
	}
}

/*
7 8
.......
......C
......*
*****.*
....*..
....*..
.C..*..
.......


5 5
C****
.....
****.
C***.
.....

5 5
C****
..*..
*.**.
C.**.
.*...

5 5
C...*
.....
.....
.....
*...C

 */
