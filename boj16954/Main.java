package boj16954;

import java.util.LinkedList;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/16954
움직이는 미로탈출
0 ~ 8 초후 좌표를 모두 기록해놓고 BFS
*/

class Node {
	int sec;
	int y;
	int x;
	@Override
	public String toString() {
		return "Node [sec=" + sec + ", y=" + y + ", x=" + x + "]";
	}
	public Node(int sec, int y, int x) {
		super();
		this.sec = sec;
		this.y = y;
		this.x = x;
	}
	
}

public class Main {
	
	static void printarr(char[][] arr) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	static int[] dy = {-1, 1, 0, 0, 0, 1, -1, 1, -1};
	static int[] dx = {0, 0, -1, 1, 0, 1, 1, -1, -1};
	
	static char[][][] inp = new char[9][8][8];
	static boolean[][][] visit = new boolean[9][8][8];
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < 8;
	}
	
	static int bfs() {
		LinkedList<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 7, 0));
		visit[0][7][0] = true;
		int ny, nx;
		Node cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.sec == 8) return 1;
			for (int i = 0; i < 9; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (inp[cur.sec][ny][nx] != '.') continue;
				if (inp[cur.sec + 1][ny][nx] != '.') continue;
				if (visit[cur.sec + 1][ny][nx]) continue;
				visit[cur.sec + 1][ny][nx] = true;
				q.offer(new Node(cur.sec + 1, ny, nx));
			}
			
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] chs;
		for (int i = 0; i < 8; i++) {
			chs = sc.next().toCharArray();
			for (int j = 0; j < 8; j++) {
				inp[0][i][j] = chs[j];
			}
		}
		
		for (int s = 1; s <= 8; s++) {
			for (int i = 7; i >= s; i--) {
				for (int j = 0; j < 8; j++) {
					inp[s][i][j] = inp[s - 1][i - 1][j];
				}
			}
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < 8; j++) {
					inp[s][i][j] = '.';
				}
			}
		}
		
		System.out.println(bfs());
		
	}
}

/*
........
.#######
#.######
.#######
#.######
.#######
#.######
.#######
..######

###
...
...
.#.


*/