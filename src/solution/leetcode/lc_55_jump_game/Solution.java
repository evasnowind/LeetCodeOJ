package solution.leetcode.lc_55_jump_game;

public class Solution {
	/*
	 * 
	 * https://leetcode.com/problems/jump-game/?tab=Description
	 * 
	 * 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
	 * 
	 * 注意题目中说的是每个元素表示最大跳跃长度，
	 * 并不是每次必须跳这么远，比如[2,0]，那么第一次
	 * 只跳1步即可到达末尾，应返回true
	 * 
	 * 算法：每个元素都试验一下，每次都更新可以跳到的
	 * 范围，如果范围没包括最后一个元素，就false
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
