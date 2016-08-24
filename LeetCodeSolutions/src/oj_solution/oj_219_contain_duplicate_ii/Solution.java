package oj_solution.oj_219_contain_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	/*
	 * 解答来自https://discuss.leetcode.com/topic/15305/simple-java-solution
	 * 巧妙之处在于i大于k时删除了i - k之前的数据，避免了内存溢出问题，实际set中
	 * 最多存有k个数据
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null) return false;
		Set<Integer> numSet = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(i > k) numSet.remove(nums[i - k - 1]);
			if(!numSet.add(nums[i])) return true;
		}
		return false;
    }
	
	public static void main(String[] args){
		int[] test = new int[0];
		System.out.println(containsNearbyDuplicate(test, 0));
	}
}
