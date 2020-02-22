package boj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put((int) ']', (int) '[');
		map.put((int) ')', (int) '(');
		while (true) {
			boolean flag = true;
			String s = br.readLine();
			if (s.equals(".")) break;
			char[] chars =s.toCharArray();
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < chars.length; i++) {
				int ch = chars[i];
				// System.out.println(stack);
				if (ch == '(' || ch == '[') {
					stack.push(ch);	
					continue;
				}
				if (ch == ')' || ch == ']') {
					if (stack.isEmpty()) {
						flag = false;
						break;
					}
					if (stack.pop() != map.get(ch)) {
						flag = false;
						break;
					}
				}
			}
			if (!stack.isEmpty()) flag = false;
			System.out.println(flag ? "yes": "no");
		}
	}
}
