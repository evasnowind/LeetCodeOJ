package test.oj_55_jump_game;

import oj_solution.oj_55_jump_game.Solution;

public class Test_OJ_55 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int [] nums = {0};
		int [] nums2 = {0,1};
		int [] nums3 = {1,0};
		int [] nums4 = {2,3};
		int [] nums5 = {1,1,1};
		int [] nums6= {1,3};
		int [] nums7= {2,1,1,4};
		int [] nums8= {3,2,1,0,4};
		int [] nums9= {2,0};
		
		System.out.println(s.canJump(nums));
		System.out.println(s.canJump(nums2));
		System.out.println(s.canJump(nums3));
		System.out.println(s.canJump(nums4));
		System.out.println(s.canJump(nums5));
		System.out.println(s.canJump(nums6));
		System.out.println(s.canJump(nums7));
		System.out.println(s.canJump(nums8));
		System.out.println(s.canJump(nums9));
	}

}
