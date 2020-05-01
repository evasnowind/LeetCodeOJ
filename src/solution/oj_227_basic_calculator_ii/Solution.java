package solution.oj_227_basic_calculator_ii;

import java.util.Stack;

public class Solution {
	/*
	 * 思路：用栈来保存计算中间结果，最后加到一起
	 * 关键点：用一个标志位保存每个数字的符号位，这样在计算乘除法时第一个操作数已经在栈顶
	 * 
	 * 另一种思路：不用栈，直接算，参见 https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1/2
	 * 
	 */
	public int calculate(String s) {
		if(null == s || s.trim().equalsIgnoreCase("")) return 0;
		int len = s.length();
		int num = 0;
		char sign = '+';
		Stack<Integer> opStack = new Stack<Integer>();
		for(int i = 0; i < len; i++){
			if(Character.isDigit(s.charAt(i))){
				num = num * 10 + s.charAt(i) - '0';
			}
			if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || (i == len-1)){
				if(sign == '+'){
					opStack.push(num);
				} else if(sign == '-'){
					opStack.push(-num);
				} else if(sign == '*'){
					opStack.push(opStack.pop() * num);
				} else if(sign == '/'){
					opStack.push(opStack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		int result = 0;
		while(!opStack.isEmpty()){
			result += opStack.pop();
		}
		return result;
    }
}
