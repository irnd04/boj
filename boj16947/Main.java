package boj16947;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int v;
	int c;
	@Override
	public String toString() {
		return "Node [v=" + v + ", c=" + c + "]";
	}
	public Node(int v, int c) {
		super();
		this.v = v;
		this.c = c;
	}
}

public class Main {
	
	static int N;
	static LinkedList<Integer>[] adj;
	static int v[];
	static int visit[];
	
	static int bfs(int vertex) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.offer(new Node(vertex, 0));
		Node cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (v[cur.v] == 2) return cur.c;
			for (int next : adj[cur.v]) {
				if (visit[next] == vertex) continue;
				visit[next] = vertex;
				q.offer(new Node(next, cur.c + 1));
			}
		}
		return -1;
	}
	
	// 정점을 다시 방문한다면 그것은 사이클이다. 서로 하나씩 연결도 싸이클 예) A - B
	// 하지만 예제에서 찾는 싸이클은 3이상이기때문에 이전정점을 방문하지않는걸로 처리한다.
	// 그러면 최소 3의 싸이클을 구할수 있음.
	// 싸이클 구하기
	// 싸이클은 2
	
	// 싸이클 진행중은 1 ~ N
	// 싸이클 못찾음 -1
	// 싸이클 찾음 0
	static int dfs(int cur, int prev) {
		// 이즈 싸이클
		if (v[cur] > 0) {
			v[cur] = 2;
			return cur;	
		}
		v[cur] = 1;
		for (int next : adj[cur]) {
			if (next == prev) continue;
			int r = dfs(next, cur);
			if (r == 0) return 0;
			if (r > 0) {
				if (cur == r) return 0;
				v[cur] = 2;
				return r;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new LinkedList[N + 1];
		v = new int[N + 1];
		visit = new int[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new LinkedList<Integer>();
		int from, to;
		for (int i = 0; i < N; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		// 싸이클 구함.
		dfs(1, 0);
		
		for (int i = 1; i <= N; i++)
			System.out.print(bfs(i) + " ");
		
	}
	
	
}

/*
6
1 2
3 4
6 4
2 3
1 3
3 5
 */
