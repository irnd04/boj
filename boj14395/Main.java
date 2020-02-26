package boj14395;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/14395
// 4����
// 10^9������ŭ �迭�� ����°� �޸� �����̸� �ʰ���.
// ���̳ʽ��� ������ ������ 0�̳� 1���ǹǷ� �����ϰ�
// �÷����� ���ϱ⿬����
// �÷��� 1 2 4 8 16 ... 2^x ����
// ���ϱ� 2 4 16 256 ... X^2 �����̹Ƿ�
// map�� ���� ó���ص� ����� �����ϴ�.
// 10�� * 10���� ��Ʈ������ ����Ƿ� ��� �����÷ο쵵 �����صξ����.

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
