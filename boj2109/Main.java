package boj2109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// 마지막날부터 최선의 선택을한다.
// 마지막날 N은 d가 N인것밖에 못고른다.
// N - 1날은 d >= N-1인것을 고를수 있다.
// 오늘이 day라면 day인 데이터를 힙에 넣고 최대값을 구한다.

class Node {
	int p;
	int d;
	@Override
	public String toString() {
		return "Node [p=" + p + ", d=" + d + "]";
	}
	public Node(int p, int d) {
		super();
		this.p = p;
		this.d = d;
	}
}

public class Main {
	
	static int N;
	static ArrayList<Node> nodes = new ArrayList<Node>();
	static PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> {
		if (a.p == b.p) return a.d - b.d;
		return b.p - a.p;
	});
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int d, p;
		int maxd = 0;
		for (int i = 0; i < N; i++) {
			p = sc.nextInt();
			d = sc.nextInt();
			nodes.add(new Node(p, d));
			maxd = Math.max(maxd, d);
		}
		
		Collections.sort(nodes, (a, b) -> b.d - a.d);
		
		int nodesi = 0;
		int sum = 0;
		for (int i = maxd; i >= 1; i--) {		
			while (nodesi < nodes.size() && nodes.get(nodesi).d == i) {
				q.offer(nodes.get(nodesi++));
			}
			if (!q.isEmpty()) sum += q.poll().p;
		}
		System.out.println(sum);
	}
}

/*
7
20 1
2 1
10 3
100 2
8 2
5 20
50 10



4
50 2
10 1
20 2
30 1

5
1 1
2 2
3 3
4 3
5 5

6
9 1
10 1
2000 2
50000 3
60000 3
90000 3

*/
