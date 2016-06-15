package oj_solution.oj_20_valid_parentheses;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		if(null == s || "".equalsIgnoreCase(s)) return true;
		char[] chs = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < chs.length; i++){
			if(!stack.isEmpty()) {
				char ch1 = stack.peek();
				char ch2 = chs[i];
				if((ch1=='{' && ch2== '}') || (ch1=='[' && ch2==']') || (ch1=='(' && ch2==')')){
					stack.pop();
				} else {
					stack.push(ch2);
				}
			} else {
				stack.push(chs[i]);
			}
		}
		return stack.empty();
	}
	
}
