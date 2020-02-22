package boj1991;

import java.util.Scanner;

class Node {
	int v;
	Node left = null;
	Node right = null;
	@Override
	public String toString() {
		return "Node [v=" + v + ", left=" + left + ", right=" + right + "]";
	}
	public Node(int v, Node left, Node right) {
		super();
		this.v = v;
		this.left = left;
		this.right = right;
	}
	
}

public class Main {
	
	static Node[] T = new Node[27];
	static int N;
	
	static void postorder(Node s) {
		if (s == null) return;
		postorder(s.left);
		postorder(s.right);
		char c = (char) (s.v + 'A');
		System.out.print(c);
	}
	
	static void inorder(Node s) {
		if (s == null) return;
		inorder(s.left);
		char c = (char) (s.v + 'A');
		System.out.print(c);
		inorder(s.right);
	}
	
	static void preorder(Node s) {
		if (s == null) return;
		char c = (char) (s.v + 'A');
		System.out.print(c);
		preorder(s.left);
		preorder(s.right);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int a, b, c;
		
		for (int i = 0; i < 27; i++) T[i] = new Node(i, null, null);
		for (int i = 0; i < N; i++) {
			a = sc.next().charAt(0) - 'A';
			b = sc.next().charAt(0) - 'A';
			c = sc.next().charAt(0) - 'A';
			if (b != -19)
				T[a].left = T[b];
			if (c != -19)
				T[a].right = T[c];
		}
		
		preorder(T[0]);
		System.out.println();
		inorder(T[0]);
		System.out.println();
		postorder(T[0]);
		
	}
}
