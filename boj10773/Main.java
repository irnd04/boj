package boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur == 0) stack.pop();
			else stack.push(cur);
		}
		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();
		System.out.println(sum);
	}

}
