package oj_test.oj_8_string_to_integer;

import oj_solution.oj_8_string_to_integer.Solution;

public class OJ_8_Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.myAtoi("34"));
		System.out.println(s.myAtoi("100"));
		System.out.println(s.myAtoi("0"));
		System.out.println(s.myAtoi("-300"));
		System.out.println(s.myAtoi("-123"));
		System.out.println(s.myAtoi("30**1"));
		System.out.println(s.myAtoi("100000000003"));
		System.out.println(s.myAtoi("401f03"));
		
		System.out.println(s.myAtoi("2147483648"));
		System.out.println(s.myAtoi("f"));
		System.out.println(s.myAtoi("+-2"));
	}

}
