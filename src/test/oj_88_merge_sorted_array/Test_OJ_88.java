package test.oj_88_merge_sorted_array;

import oj_solution.oj_88_merge_sorted_array.Solution;

public class Test_OJ_88 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums1 = new int[]{0,1,4,5,  0,0};
		int[] nums2 = new int[]{2,3};
		s.merge(nums1, 4, nums2, 2);
		int[] nums3= nums1;
	}

}
