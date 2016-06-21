package oj_test.oj_13_roman_to_integer;

import oj_solution.oj_13_roman_to_integer.Solution;

public class OJ_13_Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.romanToInt("X"));
		System.out.println(s.romanToInt("XI"));//11
		System.out.println(s.romanToInt("XIL"));//59
		System.out.println(s.romanToInt("III"));//3
		System.out.println(s.romanToInt("IV"));//4
		System.out.println(s.romanToInt("VI"));//6
		System.out.println(s.romanToInt("MCMXXC"));//2000
		System.out.println(s.romanToInt("DCXXI"));//621
		
	}

}
