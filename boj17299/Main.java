package boj17299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static int n ;
	static int[] arr;
	static int[] ans;
	static int[] counts = new int[1000001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
7
1 1 2 3 4 2 1
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		ans = new int[n];
		ans[n - 1] = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			counts[arr[i]]++;
		}
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < n - 1; i++) {
			if (counts[arr[i]] < counts[arr[i + 1]]) {
				ans[i] = arr[i + 1];
				while (!stack.isEmpty()) {
					int cur = stack.peek();
					if (counts[arr[cur]] >= counts[arr[i + 1]]) break;
					ans[cur] = arr[i + 1];
					stack.pop();
				}				
				continue;
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) ans[stack.pop()] = -1;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ans[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString());
			
		
	}
}
