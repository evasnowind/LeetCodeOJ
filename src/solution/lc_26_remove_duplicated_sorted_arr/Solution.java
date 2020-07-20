package solution.lc_26_remove_duplicated_sorted_arr;

public class Solution {
	/*
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 * 
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
	 * 
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
