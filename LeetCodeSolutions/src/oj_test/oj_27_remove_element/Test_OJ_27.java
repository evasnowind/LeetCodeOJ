package oj_test.oj_27_remove_element;

import oj_solution.oj_27_remove_element.Solution;

public class Test_OJ_27 {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] a1 = new int[]{2,3,3,2};
		System.out.println(s.removeElement(a1, 2));
		int[] a2 = new int[]{1};
		System.out.println(s.removeElement(a2, 1));
	}
}
