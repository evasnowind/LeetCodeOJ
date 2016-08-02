package oj_solution.oj_169_majority_element;

import java.util.Arrays;

public class Solution {
	/*
	 * 思路简单：题目已明确说明数组非空、必然存在majority num，
	 * 并且这个元素出现次数超过n/2(下取整)，那么无论何种情况，
	 * 排序后第n/2(下取整)个数必然是majority num。java整数
	 * 除法的结果直接就是下取整，也不需要做额外处理，因此直接
	 * 两行搞定！
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
