package boj12886;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void swap(int[] arr) {
		int temp;
		if (arr[0] > arr[1]) {
			temp = arr[0];
			arr[0] = arr[1];
			arr[1] = temp;
		}
	}
	
	public static int[] oper(int[] arr) {
		swap(arr);
		int[] ret = new int[] {arr[0] * 2, arr[1] - arr[0]};
		return ret;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[] {sc.nextInt(), sc.nextInt()};
		
		while (true) {
			
			System.out.println(Arrays.toString(arr));
			
			boolean found = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= 1000) found = true;
			}
			if (found) break;
			
			if (arr[0] == arr[1]) break;
			
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			arr = oper(arr);
			
		}
		
	}
	
}
