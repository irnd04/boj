package boj1931;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1931
// 회의실배정
// 유명한 그리디문제
// 가장빨리 끝나는 회의순으로 진행한다.
// 가장빨리끝나는 회의먼저해야 다음 선택의수가 많아지기때문

// 3.3, 1.3, 3.3 의 입력의경우
// 1.3부터 회의를 진행하면 3개를 할수있고
// 3.3부터 진행하면 2개를 할수있다.
// 그러므로 시작시간도 같이 고려하여 정렬한다.

class Node {
	int s;
	int e;
	public Node(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
	@Override
	public String toString() {
		return "Node [s=" + s + ", e=" + e + "]";
	}	
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			nodes.add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(nodes, (a, b) -> {
			if (a.e == b.e)
				return a.s - b.s;
			return a.e - b.e;
		});
		
		int end = 0;
		int r = 0;
		
		for (Node cur : nodes) {
			if (end <= cur.s) {
				end = cur.e;
				r++;
			}
		}
		
		System.out.println(r);
	}
	
}
