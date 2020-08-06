package solution.leetcode.lc_448_find_all_numbers_disappeared_in_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/**
	 * 分析：首先要看清题目、输入与输出，直观思路是用一个hashset或是用一个标记
	 * 		数据，但题目要求不能用额外空间，其实也是一个提示，
	 * 		这种情况下，我的第一反应是用一个int数的二进制位作为标记，但这里由于
	 * 		输入是一个数组，而我们只关心数据是否存在，没有说必须保持数组里的每个值，
	 * 		那么这时可以考虑用输入数组同时保存标记和数据。下面算法来自：
	 * 	https://discuss.leetcode.com/topic/65738/java-accepted-simple-solution
	 * 
	 * PS：这种利用输入数据的正负作为标记的思路很值得借鉴，但务必要注意使用场合，必须是
	 * 		改变原数据不会影响结果的情况
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			/*
			 * 此处必须加绝对值，否则可能出现val为负数的情况
			 */
			int val = Math.abs(nums[i]) - 1;
			if(nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0){
				res.add(i+1);
			}
		}
		return res; 
    }
}
