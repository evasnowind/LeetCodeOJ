package oj_test.oj_66_plus_one;

import oj_solution.oj_66_plus_one.Solution;

public class TestOJ66 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] a1 = {1};
		int[] a2 = {};
		int[] a3 = {1,9};
		int[] a4 = {2,9,9};
		int[] a5 = {9,9,9};
		int[] a6 = {9};
		int[] result = null;
		result = s.plusOne(a1);
		result = s.plusOne(a2);
		result = s.plusOne(a3);
		result = s.plusOne(a4);
		result = s.plusOne(a5);
		result = s.plusOne(a6);
	}

}
