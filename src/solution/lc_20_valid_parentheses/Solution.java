package solution.lc_20_valid_parentheses;

import java.util.Stack;

public class Solution {
	/*
	 * 
	 * https://leetcode.com/problems/valid-parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

	分析：思路比较简单，和表达式求值有些神似，都是利用栈进行推导
	 */
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
