package oj_solution.oj_26_remove_duplicated_sorted_arr;

public class Solution {
	/*
	 * 一般思路：
	 * 	（1）使用哈希表，扫描一次，时间O(N) 空间O(N)
	 * 	（2）每读一个值，就向后扫描，时间O(N*N) 空间O(1)
	 * 
	 * 题目要求常量存储空间，并且提示可以改变数组内容，
	 * 因此可以采用这种复制的手段
	 */
	public int removeDuplicates(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
		int cnt = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i-1])
				cnt++;
			else
				nums[i-cnt] = nums[i];
		}
        return nums.length - cnt;
    }
}
