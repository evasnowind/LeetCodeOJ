package oj_solution.oj_55_jump_game;

public class Solution {
	/*
	 * 注意题目中说的是每个元素表示最大跳跃长度，
	 * 并不是每次必须跳这么远，比如[2,0]，那么第一次
	 * 只跳1步即可到达末尾，应返回true
	 */
	public boolean canJump(int[] nums) {
		if(null == nums || nums.length == 0) return false;
		int i = 0;
		for(int reach = 0; i < nums.length && i <= reach; i++) {
			reach = Math.max(i+nums[i], reach);
		}
		return i == nums.length;
    }
}
