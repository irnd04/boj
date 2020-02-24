package boj16236;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	public Node(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + "]";
	}
	
}

public class Main {
	
	static int N;
	static int[][] inp;
	static int[][] chk;
	
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	static int size = 2;
	static int e = 0;
	
	static void eat() {
		e++;
		if (size == e) {
			size++;
			e = 0;
		}
	}
	
	static void printarr(int[][] arr, Node pos) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pos.y == i && pos.x == j) System.out.print("* ");
				else System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N; 
	}
	
	static int bfs(Node pos) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				chk[i][j] = -1;
		chk[pos.y][pos.x] = 0;
		LinkedList<Node> q = new LinkedList<Node>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		Node cur;
		int ny, nx;
		int dist = -2;
		q.offer(new Node(pos.y, pos.x));
		while (!q.isEmpty()) {
			cur = q.poll();
			if (inp[cur.y][cur.x] != 0 && inp[cur.y][cur.x] < size) {
				nodes.add(new Node(cur.y, cur.x));
			}
			
			for (int i = 0; i < 4; i++) {
				ny = cur.y + dy[i];
				nx = cur.x + dx[i];
				if (!inrange(ny, nx)) continue;
				if (chk[ny][nx] != -1) continue;
				if (inp[ny][nx] > size) continue;
				chk[ny][nx] = chk[cur.y][cur.x] + 1;
				q.offer(new Node(ny, nx));
			}
		}
		
		Collections.sort(nodes, (a, b) -> {
			if (chk[a.y][a.x] == chk[b.y][b.x]) {
				if (a.y == b.y) return a.x - b.x;
				return a.y - b.y;
			}
			return chk[a.y][a.x] - chk[b.y][b.x];
		});
		
		
		if (nodes.size() == 0) return -1;
		pos.y = nodes.get(0).y;
		pos.x = nodes.get(0).x;
		inp[pos.y][pos.x] = 0;
		eat();
		return chk[pos.y][pos.x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		inp = new int[N][N];
		chk = new int[N][N];
		Node pos = null;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				inp[i][j] = sc.nextInt();
				if (inp[i][j] == 9) {
					pos = new Node(i, j);	
					inp[i][j] = 0;
				}
			}
		}
		int sum = 0;
		while (true) {
			int r = bfs(pos);
			if (r == -1) break;
			sum += r;
//			System.out.println(r + "(" + size + ", " + e + ")" + " :: " + sum);
//			printarr(inp, pos);
//			sc.next();
		}
		System.out.println(sum);
	}
}
