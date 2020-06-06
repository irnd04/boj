package boj2250;

import java.util.Arrays;
import java.util.Scanner;

class Node {
	int v;
	Node l;
	Node r;
	int o;
	int level;
	public Node(int v, Node l, Node r) {
		super();
		this.v = v;
		this.l = l;
		this.r = r;
	}
	@Override
	public String toString() {
		return "Node [v=" + v + ", l=" + l + ", r=" + r + ", o=" + o + "]";
	}
	
}

public class Main {
	
	static int N;
	static Node[] T = new Node[10001];
	static int o;
	static int maxd;
	static int[] min;
	static int[] max;
	static int[] idg;
	
	static void inorder(Node s) {
		if (s == null) return;
		inorder(s.l);
		s.o = ++o;
		inorder(s.r);
	}
	
	static void preorder(Node s, int d) {
		if (s == null) {
			maxd = Math.max(maxd, d);
			return;
		}
		s.level = d;
		preorder(s.l, d + 1);
		preorder(s.r, d + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		idg = new int[N + 1];
		for (int i = 1; i <= N; i++) T[i] = new Node(i, null, null);
		int a, b, c;
		int root = -1;
		for (int i = 0; i < N; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if (b != -1) {
				idg[b]++;
				T[a].l = T[b];	
			}
			if (c != -1) {
				idg[c]++;
				T[a].r = T[c];	
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (idg[i] == 0) {
				root = i;
				break;
			}
		}
			
		inorder(T[root]);
		preorder(T[root], 1);
		min = new int[maxd];
		max = new int[maxd];
		for (int i = 1; i < maxd; i++) {
			min[i] = N;
			max[i] = 1;
		}
			
		for (int i = 1; i <= N; i++) {
			int level = T[i].level;
			int order = T[i].o;
			min[level] = Math.min(min[level], order);
			max[level] = Math.max(max[level], order);
		}
		int r = 0, ri = 0;
		for (int i = 1; i < maxd; i++) {
			int v = max[i] - min[i] + 1;
			if (r < v) {
				ri = i;
				r = v;
			}
		}
		System.out.println(ri + " " + r);
	}
}

/*
20
1 2 3
2 4 5
3 6 7
4 8 -1
5 9 10
6 11 12
7 13 -1
8 -1 -1
9 14 15
10 -1 -1
11 16 -1
12 -1 -1
13 17 -1
14 -1 -1
15 18 -1
16 -1 -1
17 -1 19
18 -1 -1
19 -1 20
20 -1 -1
*/
