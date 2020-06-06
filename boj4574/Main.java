package boj4574;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int v1;
	int v2;
	public Node(int v1, int v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
	}
	@Override
	public String toString() {
		return "Node [v1=" + v1 + ", v2=" + v2 + "]";
	}
}

public class Main {
	
	static int N = 9;
	static boolean[][] domino = new boolean[N + 1][N + 1];
	static ArrayList<Node> doms = new ArrayList<Node>();
	static int[][] inp = new int[N][N];
	static int[] res = new int[2];
	static int domN;
	
	static boolean[][] ga = new boolean[N][N + 1]; // a행에    b가 있는지?
	static boolean[][] se = new boolean[N][N + 1]; // a열에    b가 있는지?
	static boolean[][] ar = new boolean[N][N + 1]; // a구역에 b가 있는지?
	
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	static boolean end;
	
	static void printarr(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean inrange(int y, int x) {
		return Math.min(y, x) >= 0 && Math.max(y, x) < N;
	}
	
	static boolean chksdoku(int i, int j, int x) {
		return ga[i][x] || se[j][x] || ar[aridx(i, j)][x];
	}
	
	static void setsdoku(int i, int j, int x, boolean v) {
		ga[i][x] = v;
		se[j][x] = v;
		ar[aridx(i, j)][x] = v;
	}
	
	static void makedoms(int p, int s) {
		if (p == 2) {
			if (domino[res[0]][res[1]]) return;
			doms.add(new Node(res[0], res[1]));
			return;
		}
		for (int i = s; i <= 9; i++) {
			res[p] = i;
			makedoms(p + 1, i + 1);
		}
	}
	
	static int aridx(int i, int j) {
		int idx = (i / 3) * (N / 3) + j / 3;
		return idx;
	}
	
	static int[] pos() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (inp[i][j] == 0) return new int[] {i, j};
			}
		}
		return null;
	}
	
	static void solve(int p) {
		if (end) return;
		if (p == doms.size()) {
			end = true;
			printarr(inp);
			return;
		} 
		int y, x, ny, nx;
		int[] yx = pos();
		y = yx[0];
		x = yx[1];
		
		for (Node dom : doms) {
			if (domino[dom.v1][dom.v2]) continue;
			inp[y][x] = dom.v1;
			if (!chksdoku(y, x, inp[y][x])) {
				setsdoku(y, x, inp[y][x], true);
				for (int k = 0; k < 4; k++) {
					ny = y + dy[k];
					nx = x + dx[k];
					if (!inrange(ny, nx)) continue;
					if (inp[ny][nx] != 0) continue;
					if (chksdoku(ny, nx, dom.v2)) continue;
					inp[ny][nx] = dom.v2;
					setsdoku(ny, nx, dom.v2, true);
					domino[dom.v1][dom.v2] = true;
					solve(p + 1);
					if (end) return;
					inp[ny][nx] = 0;
					setsdoku(ny, nx, dom.v2, false);
					domino[dom.v1][dom.v2] = false;
				}
				setsdoku(y, x, inp[y][x], false);
			}
			inp[y][x] = dom.v2;
			if (!chksdoku(y, x, inp[y][x])) {
				setsdoku(y, x, inp[y][x], true);
				for (int k = 0; k < 4; k++) {
					ny = y + dy[k];
					nx = x + dx[k];
					if (!inrange(ny, nx)) continue;
					if (inp[ny][nx] != 0) continue;
					if (chksdoku(ny, nx, dom.v1)) continue;
					inp[ny][nx] = dom.v1;
					setsdoku(ny, nx, dom.v1, true);
					domino[dom.v1][dom.v2] = true;
					solve(p + 1);
					if (end) return;
					inp[ny][nx] = 0;
					setsdoku(ny, nx, dom.v1, false);
					domino[dom.v1][dom.v2] = false;
				}
				setsdoku(y, x, inp[y][x], false);
			}
			inp[y][x] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = 0;
		while (true) {
			
			domino = new boolean[N + 1][N + 1];
			doms = new ArrayList<Node>();
			inp = new int[N][N];
			ga = new boolean[N][N + 1]; // a행에    b가 있는지?
			se = new boolean[N][N + 1]; // a열에    b가 있는지?
			ar = new boolean[N][N + 1]; // a구역에 b가 있는지?
			end = false;
			
			domN = sc.nextInt();
			if (domN == 0) return;
			char[] chs;
			int v1, v2;
			int y1, x1, y2, x2;
			for (int i = 0; i < domN; i++) {
				v1 = sc.nextInt();
				chs = sc.next().toCharArray();
				y1 = chs[0] - 'A';
				x1 = chs[1] - '0' - 1;
				v2 = sc.nextInt();
				chs = sc.next().toCharArray();
				y2 = chs[0] - 'A';
				x2 = chs[1] - '0' - 1;
				inp[y1][x1] = v1;
				inp[y2][x2] = v2;
				setsdoku(y1, x1, v1, true);
				setsdoku(y2, x2, v2, true);
				domino[v1][v2] = true;
				domino[v2][v1] = true;
			}
			for (int i = 1; i <= 9; i++) {
				chs = sc.next().toCharArray();
				y1 = chs[0] - 'A';
				x1 = chs[1] - '0' - 1;
				inp[y1][x1] = i;
				setsdoku(y1, x1, i, true);
			}
			makedoms(0, 1);
			System.out.println("Puzzle " + (++c));
			solve(0);
		}
	}
}

/*
10
6 B2 1 B3
2 C4 9 C3
6 D3 8 E3
7 E1 4 F1
8 B7 4 B8
3 F5 2 F6
7 F7 6 F8
5 G4 9 G5 
7 I8 8 I9
7 C9 2 B9
C5 A3 D9 I4 A9 E5 A2 C6 I1
*/
