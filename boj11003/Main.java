package boj11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			if (!deq.isEmpty() && deq.peekFirst() == i - L) deq.pollFirst();
			while (!deq.isEmpty() && arr[deq.peekLast()] >= arr[i]) deq.pollLast();
			deq.offer(i);
			bw.write(arr[deq.peekFirst()] + " ");
		}
		bw.flush();
		bw.close();
	}
}
