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
	
	// ������ �ٽ� �湮�Ѵٸ� �װ��� ����Ŭ�̴�. ���� �ϳ��� ���ᵵ ����Ŭ ��) A - B
	// ������ �������� ã�� ����Ŭ�� 3�̻��̱⶧���� ���������� �湮�����ʴ°ɷ� ó���Ѵ�.
	// �׷��� �ּ� 3�� ����Ŭ�� ���Ҽ� ����.
	// ����Ŭ ���ϱ�
	// ����Ŭ�� 2
	
	// ����Ŭ �������� 1 ~ N
	// ����Ŭ ��ã�� -1
	// ����Ŭ ã�� 0
	static int dfs(int cur, int prev) {
		// ���� ����Ŭ
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
		// ����Ŭ ����.
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
