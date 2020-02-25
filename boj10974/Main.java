package boj10974;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	
	static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static boolean next_perm() {
		// arr[i - 1] < A[i]�� �����ϴ� ���� ū i�� ã�´�. (a�� ����)
		int a = -1;
		for (int i = 1; i < N; i++) if (arr[i - 1] < arr[i]) a = i;
		if (a == -1) return false;
		
		// i >= a �̸鼭 arr[i] > arr[a - 1]�� �����ϴ� ���� ū i�� ã�´�. (b�� ����)
		int b = -1;
		for (int i = a; i < N; i++) if (arr[a - 1] < arr[i]) b = i;
		
		// arr[a - 1]�� arr[b]�� swap�Ѵ�.
		swap(a - 1, b);
		
		// arr[a]���� ������ �����´�.
		b = N - 1;
		while (a < b) {
			swap(a, b);
			a++;
			b--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 1; i <= N; i++) arr[i - 1] = i;
		do {
			for (int i = 0; i < N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		} while(next_perm());
	}
}
