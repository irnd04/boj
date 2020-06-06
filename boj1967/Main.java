package boj1967;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Node {
	int v;
	int cost;
	public Node(int v, int cost) {
		super();
		this.v = v;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Node [v=" + v + ", cost=" + cost + "]";
	}	
}

public class Main {
	
	static int N;
	static LinkedList<Node>[] adj;
	static int[] dist;
	
	static void clear() {
		for (int i = 1; i <= N; i++)
			dist[i] = -1;
	}
	
	static void dfs(int s, int cost) {
		if (dist[s] != -1) return;
		dist[s] = cost;
		for (Node next : adj[s]) dfs(next.v, cost + next.cost);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new LinkedList[N + 1];
		dist = new int[N + 1];
		int from, to, cost;
		for (int i = 1; i <= N; i++) {
			adj[i] = new LinkedList<Node>();
			dist[i] = -1;
		}
		for (int i = 0; i < N - 1; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			cost = sc.nextInt();
			adj[from].add(new Node(to, cost));
			adj[to].add(new Node(from, cost));
		}
		
		dfs(1, 0);
		int max = dist[1];
		int maxi = 1;
		for (int i = 1; i <= N; i++) {
			if (max < dist[i]) {
				max = dist[i];
				maxi = i;
			}
		}
		clear();
		dfs(maxi, 0);
		max = dist[1];
		maxi = 1;
		for (int i = 1; i <= N; i++) {
			if (max < dist[i]) {
				max = dist[i];
				maxi = i;
			}
		}
		System.out.println(max);
	}
}

/*
12
1 2 3
1 3 2
2 4 5
3 5 11
3 6 9
4 7 1
4 8 7
5 9 15
5 10 4
6 11 6
6 12 10
*/