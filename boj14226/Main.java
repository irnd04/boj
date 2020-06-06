package boj14226;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int v;
	int c;
	int cost;
	@Override
	public String toString() {
		return "Node [v=" + v + ", c=" + c + ", cost=" + cost + "]";
	}
	public Node(int v, int c, int cost) {
		super();
		this.v = v;
		this.c = c;
		this.cost = cost;
	}
	
}

public class Main {
	
	static int S;
	static final int INF = 40000;
	static boolean[][] chk = new boolean[2001][2001];
	static Scanner sc = new Scanner(System.in);
	
	static boolean inrange(int S) {
		return 1 <= S && S < 2001;
	}
	
	static int solve(int s) {
		LinkedList<Node> q = new LinkedList<Node>();
		chk[s][0] = true;
		q.offer(new Node(s, 0, 0));
		Node cur;
		while (!q.isEmpty()) {
			
			cur = q.poll();
			
			if (cur.v == S) return cur.cost;
			
			if (inrange(cur.v - 1) && !chk[cur.v - 1][cur.c]) {
				chk[cur.v - 1][cur.c] = true;
				q.offer(new Node(cur.v - 1, cur.c, cur.cost + 1));
			}
			
			// 복사
			if (cur.v != cur.c && !chk[cur.v][cur.v]) {
				chk[cur.v][cur.v] = true;
				q.offer(new Node(cur.v, cur.v, cur.cost + 1));
			}
				
			
			// 붙히기
			if (inrange(cur.v + cur.c) && cur.c != 0 &&
					!chk[cur.v + cur.c][cur.c]) {
				chk[cur.v + cur.c][cur.c] = true;
				q.offer(new Node(cur.v + cur.c, cur.c, cur.cost + 1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		S = sc.nextInt();
		System.out.println(solve(1));
		
	}
	
}
