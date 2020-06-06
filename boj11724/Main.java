package boj11724;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	static int V, E;
	static int[] p;
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa > pb) p[pa] = pb;
		else p[pb] = pa;
	}
	
	static int find(int x) {
		if (p[x] != x) p[x] = find(p[x]);
		return p[x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		p = new int[V + 1];
		for (int i = 0; i < p.length; i++) p[i] = i;
		
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i <= V; i++)
			set.add(find(i));
		
		System.out.println(set.size());
	}
}

/*
6 5
1 2
2 5
5 1
3 4
4 6
*/