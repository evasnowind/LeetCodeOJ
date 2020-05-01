package test.oj_26_remove_duplicated;

import oj_solution.oj_26_remove_duplicated_sorted_arr.Solution;

public class Test_OJ_26 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int [] a1 = {1,1,2};
		int [] a2 = {1,1,1};
		int [] a3 = {};
		int [] a4 = {1,2,3,4};
		int [] a5 = {1};
		
		System.out.println(s.removeDuplicates(a1));
		System.out.println(s.removeDuplicates(a2));
		System.out.println(s.removeDuplicates(a3));
		System.out.println(s.removeDuplicates(a4));
		System.out.println(s.removeDuplicates(a5));
		
	}

}
