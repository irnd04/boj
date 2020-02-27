package boj1202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

// 간단한 문제인데
// 로우어바운드랑 로우어바운드에서 나온 키를 삭제해야한다.

// BST를 사용하면된다.
// java 트리맵에 이런 다양한 함수들이 존재하는줄 몰랐다.

// bag.ceilingKey(key) 크거나 같은것중 가장 작은것 반환 없으면 NULL (Lower Bound)
// bag.floorKey(key)   작거나 같은것중 가장 큰것 반환 없으면 NULL
// bag.higherKey(key)  큰것중 가장 작은것 반환 없으면 NULL       (Upper Bound)
// bag.lowerKey(key)   작은것중 가장 큰것 반환 없으면 NULL

class Node {
	int w;
	int v;
	@Override
	public String toString() {
		return "Node [w=" + w + ", v=" + v + "]";
	}
	public Node(int w, int v) {
		super();
		this.w = w;
		this.v = v;
	}
}

public class Main {
	
	static int N, K;
	static TreeMap<Integer, Integer> bag = new TreeMap<Integer, Integer>();
	static ArrayList<Node> jewels = new ArrayList<Node>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		for (int i = 0; i < N; i++)
			jewels.add(new Node(sc.nextInt(), sc.nextInt()));
		
		Collections.sort(jewels, (a, b) -> {
			if (a.v == b.v)
				return a.w - b.w;
			return b.v - a.v;
		});
		
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			Integer val = bag.get(x);
			if (val == null) val = 0;
			val++;
			bag.put(x, val);
		}
		
		long sum = 0;
		for (Node j : jewels) {
			Integer k = bag.ceilingKey(j.w);
			if (k == null) continue;
			sum += j.v;
			int kc = bag.get(k);
			kc--;
			if (kc == 0) {
				bag.remove(k);
				if (bag.isEmpty()) break;
			}
			else bag.put(k, kc);
		}
		
		System.out.println(sum);
	}
}
/*
4 3
2 65
5 23
2 23
2 99
10
9
1
*/