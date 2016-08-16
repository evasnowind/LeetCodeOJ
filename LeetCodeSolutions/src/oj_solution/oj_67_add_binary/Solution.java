package oj_solution.oj_67_add_binary;

public class Solution {
	/*
	 * 思路比较简单，但参考了https://discuss.leetcode.com/topic/13698/short-ac-solution-in-java-with-explanation
	 * 因为这种写法更简洁，可以学习下
	 */
	public String addBinary(String a, String b) {
		if(null == a || a.isEmpty()) return b;
		if(null == b || b.isEmpty()) return a;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
		while(i >= 0 || j >= 0){
			sum = carry;
			if(j >= 0) sum += b.charAt(j--) - '0';
			if(i >= 0) sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
    }
}
