package boj14395;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14395
// 4연산
// 10^9제곱만큼 배열을 만드는건 메모리 낭비이며 초과다.
// 마이너스나 나누기 연산은 0이나 1만되므로 무시하고
// 플러스나 곱하기연산은
// 플러스 1 2 4 8 16 ... 2^x 형태
// 곱하기 2 4 16 256 ... X^2 형태이므로
// map을 만들어서 처리해도 충분히 가능하다.
// 10억 * 10억은 인트범위를 벗어나므로 산술 오버플로우도 염두해두어야함.

public class Main {
	
	static long S;
	static long E;
	static HashMap<Long, Long> from = new HashMap<Long, Long>();
	static HashMap<Long, Long> how = new HashMap<Long, Long>();
	static String r = "";
	static char[] oper = new char[] {'*', '+', '-', '/'};
	
	static void bfs() {
		from.put(S, -1l);
		how.put(S, -1l);
		LinkedList<Long> q = new LinkedList<Long>();
		q.offer(S);
		long cur;
		long next;
		while (!q.isEmpty()) {
			
			cur = q.poll();
			if (cur == E) return;
			
			next = cur * cur;
			if (next <= E && !from.containsKey(next)) {
				from.put(next, cur);
				how.put(next, 0l);
				q.offer(next);
			}
			
			next = cur + cur;
			if (next <= E && !from.containsKey(next)) {
				from.put(next, cur);
				how.put(next, 1l);
				q.offer(next);
			}
			
			next = cur - cur;
			if (next <= E && !from.containsKey(next)) {
				from.put(next, cur);
				how.put(next, 2l);
				q.offer(next);
			}
			
			if (cur == 0) continue;
			
			next = cur / cur;
			if (next <= E && !from.containsKey(next)) {
				from.put(next, cur);
				how.put(next, 3l);
				q.offer(next);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		E = sc.nextLong();
		
		if (S == E) {
			System.out.println(0);
			return;
		}
		
		bfs();
		if (from.get(E) == null) {
			System.out.println(-1);
			return;
		}
		
		track(E);
		System.out.println(r);
	}
	
	static void track(long x) {
		if (from.get(x) == -1) return;
		track(from.get(x));
		int i = (int) (how.get(x) + 0l);
		r += oper[i];
	}
}
