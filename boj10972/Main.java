package boj10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static boolean next_perm() {
		
		
		// arr[i - 1] < A[i]를 만족하는 가장 큰 i를 찾는다. (a에 저장)
		int a = -1;
		for (int i = 1; i < N; i++) if (arr[i - 1] < arr[i]) a = i;
		if (a == -1) return false;
		
		// i >= a 이면서 arr[i] > arr[a - 1]를 만족하는 가장 큰 i를 찾는다. (b에 저장)
		int b = -1;
		for (int i = a; i < N; i++) if (arr[a - 1] < arr[i]) b = i;
		
		// arr[a - 1]과 arr[b]를 swap한다.
		swap(a - 1, b);
		
		// arr[a]부터 순열을 뒤집는다.
		b = N - 1;
		while (a < b) {
			swap(a, b);
			a++;
			b--;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean flag = next_perm();
		if (flag) {
			for (int i = 0; i < N; i++)
				System.out.print(arr[i] + " ");
			return;
		}
		System.out.println(-1);
	}
	
}
