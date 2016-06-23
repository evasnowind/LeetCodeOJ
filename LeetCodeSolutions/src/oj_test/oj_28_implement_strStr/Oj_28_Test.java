package oj_test.oj_28_implement_strStr;

import oj_solution.oj_28_implement_strStr.Solution;

public class Oj_28_Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.strStr("abc", "b"));
		System.out.println(s.strStr("abc", "bc"));
		System.out.println(s.strStr("abc", "a"));
		System.out.println(s.strStr("abc", ""));
		System.out.println(s.strStr("aaa", "aaaa"));
	}

}
