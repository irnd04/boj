package boj507;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int y;
	int x;
	@Override
	public String toString() {
		return "Node [y=" + y + ", x=" + x + "]";
	}
	public Node(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class Main {

	static int N = 9;
	static int M;
	static boolean[][] ga = new boolean[10][10]; // y행에 x가 있는지?
	static boolean[][] se = new boolean[10][10]; // y열에 x가 있는지?
	static boolean[][] ar = new boolean[10][10]; // y구역에 x가 있는지?
	static ArrayList<Node> li = new ArrayList<Node>();
	static boolean[] chk = new boolean[81];
	static int[] res = new int[81];
	static int[][] inp = new int[10][10];
	
	static int aidx(int y, int x) {
		int idx = ((y - 1) / 3) * (N / 3) + 1 + (x - 1) / 3;
		return idx;
	}
	
	static void perm(int p) {
		Node cur;
		if (p == M) {
			for (int i = 0; i < M; i++) {
				cur = li.get(i);
				inp[cur.y][cur.x] = res[i];
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(inp[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}		
		for (int i = 1; i <= 9; i++) {
			cur = li.get(p);
			if (ga[cur.y][i]) continue;
			if (se[cur.x][i]) continue;
			if (ar[aidx(cur.y, cur.x)][i]) continue;
			ga[cur.y][i] = true;
			se[cur.x][i] = true;
			ar[aidx(cur.y, cur.x)][i] = true;
			res[p] = i;
			perm(p + 1);
			ga[cur.y][i] = false;
			se[cur.x][i] = false;
			ar[aidx(cur.y, cur.x)][i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				inp[i][j] = sc.nextInt();
				if (inp[i][j] == 0) {
					li.add(new Node(i, j));
				}
				else {
					ga[i][inp[i][j]] = true;
					se[j][inp[i][j]] = true;
					ar[aidx(i, j)][inp[i][j]] = true;
				}
			}
		}
		M = li.size();
		perm(0);
	}
}
