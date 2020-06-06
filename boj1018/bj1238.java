package boj1018;

import java.util.*;

class Node {
	int v;
	int cost;
	@Override
	public String toString() {
		return "Node [v=" + v + ", cost=" + cost + "]";
	}
	public Node(int v, int cost) {
		super();
		this.v = v;
		this.cost = cost;
	}
	
}

public class bj1238 {
	
	static int N, M, X;
	static int[] dist;
	static int[] dist2;
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Node>[] adj;
	static int INF = Integer.MAX_VALUE;
	
	static void dijk(int s) {
		PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		for (int i = 1; i <= N; i++)
			dist[i] = INF;
		dist[s] = 0;
		q.offer(new Node(s, 0));
		Node cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.cost > dist[cur.v]) continue;
			for (Node next : adj[cur.v]) {
				if (dist[next.v] > cur.cost + next.cost) {
					dist[next.v] = cur.cost + next.cost;
					q.offer(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();
		
		adj = new LinkedList[N + 1];
		dist = new int[N + 1];
		dist2 = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<Node>();
		}
		
		int from, to, cost;
		
		for (int i = 0; i < M; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			cost = sc.nextInt();
			adj[from].add(new Node(to, cost));
		}
		
		dijk(X);
		
		for (int i = 1; i <= N; i++) dist2[i] = dist[i];
		
		for (int i = 1; i <= N; i++) {
			if (i == X) continue;
			dijk(i);
			dist2[i] += dist[X];
		}
		
		int max = dist2[X];
		for (int i = 1; i <= N; i++)
			max = Math.max(dist2[i], max);
		
		System.out.println(max);
		
	}
}
