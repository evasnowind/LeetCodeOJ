package test.oj_9_palindrome_number;

import oj_solution.oj_9_palindrome_number.Solution;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isPalindrome(123321));
		System.out.println(s.isPalindrome(-123321));
		System.out.println(s.isPalindrome(0));
		System.out.println(s.isPalindrome(100));
		System.out.println(s.isPalindrome(Integer.MAX_VALUE));
		System.out.println(s.isPalindrome(12321));
	}

}
