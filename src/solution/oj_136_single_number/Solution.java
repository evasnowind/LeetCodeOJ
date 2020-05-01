package solution.oj_136_single_number;

public class Solution {
	/*
	 * 经典题，利用位的异或特性，相同数字异或后相互抵消
	 */
	public int singleNumber(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
		int res = 0;
		for(int n : nums){
			res = res ^ n;
		}
		return res;
    }
}
