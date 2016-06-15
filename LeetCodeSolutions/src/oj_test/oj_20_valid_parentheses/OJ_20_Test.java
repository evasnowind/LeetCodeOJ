package oj_test.oj_20_valid_parentheses;

import oj_solution.oj_20_valid_parentheses.Solution;

public class OJ_20_Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("{}"));
		System.out.println(s.isValid("{[}]"));
		System.out.println(s.isValid("{()[(){[()]}]}"));
		System.out.println(s.isValid("{"));
		System.out.println(s.isValid("[](){}"));
		
	}

}
