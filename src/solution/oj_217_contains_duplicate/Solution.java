package solution.oj_217_contains_duplicate;

import java.util.Arrays;

public class Solution {
	/*
	 * 思路比较简单的题目：
	 * 方法1：双重循环，内层循环的次数依次减少，时间复杂度不到O(n*n)
	 * 方法2：先排序，再比较（如下），由于经过排序，只需要一次遍历即可得出结果，时间 O(n*log(n))
	 * 方法3：直接用hashset，空间O(n) 时间O(1)
	 */
	public boolean containsDuplicate(int[] nums) {
		if(null == nums || nums.length == 0) return false;
		Arrays.sort(nums);
		boolean result = false;
		for(int i = 1; i < nums.length; i++){
			if(nums[i-1] == nums[i]){
				result = true;
				break;
			}
		}
		return result;
    }
}
