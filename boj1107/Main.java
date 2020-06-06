package boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static boolean[] broken = new boolean[256];
	static int cur = 100;
	static int N;
	
	public static boolean ok(int n) {
		for (char ch : String.valueOf(n).toCharArray()) {
			if (broken[(int) ch]) return false;
		}
		return true;
	}
	
	public static int[] find() {
		int up = -1;
		int down = -1;
		for (int i = N + 1; i <= 4444444; i++) {
			if (ok(i)) {
				up = i;
				break;
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			if (ok(i)) {
				down = i;
				break;
			}
		}
		return new int[] {up, down};
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		if (m > 0) {
			String s = br.readLine();
			char[] chars = s.replaceAll(" +", "").toCharArray();
			for (int i = 0; i < chars.length; i++)		
				broken[(int) chars[i]] = true;	
		}
		
		int min = Integer.MAX_VALUE;
		if (N == cur) {
			System.out.println(0);
			return;	
		}
		if (!broken[(int) '+'] &&
				N > cur)
			min = Math.min(N - cur, min);
		if (!broken[(int) '-'] &&
				N < cur)
			min = Math.min(cur - N, min);
		
		if (ok(N)) min = Math.min(min, String.valueOf(N).length());
		
		int[] ud = find();
		int up = ud[0];
		int down = ud[1];
		
		// System.out.println(Arrays.toString(ud));
		
		if (!broken[(int) '+']) {
			if (down != -1 && down < N)
				min = Math.min(N - down
						+ String.valueOf(down).length(), min);
			if (up != -1 && up < N)
				min = Math.min(N - up
						+ String.valueOf(up).length(), min);
		}
		
		if (!broken[(int) '-']) {		
			if (down != -1 && down > N)
				min = Math.min(down - N 
						+ String.valueOf(down).length(), min);
			if (up != -1 && up > N)
				min = Math.min(up - N
						+ String.valueOf(up).length(), min);
		}
		
		System.out.println(min);
		
	}
}
