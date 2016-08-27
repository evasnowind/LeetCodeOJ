package oj_solution.oj_268_missing_number;

public class Solution {
	/*
	 * 基本思路：用一个boolean数组，遍历2次，第一次将nums数组中所有出现的数
	 * 			在boolean数组对应位置置为true，第二次遍历boolean数组即可
	 * 			O(n) 时间  O(n)空间
	 * 基本思路2：用一个数字进行位运算来代替boolean数组，以保存标志位，但也就是
	 * 			一种另外的思路，效率比较低
	 * 基本思路3：排序后遍历，看不连续的位置	O(nlogn) 时间  O(1)空间
	 * 优化后思路：参见
	 * 
	 * https://discuss.leetcode.com/topic/24535/4-line-simple-java-bit-manipulate-solution-with-explaination/2
	 * 
	 * https://discuss.leetcode.com/topic/24535/4-line-simple-java-bit-manipulate-solution-with-explaination/5
	 * 
	 * https://discuss.leetcode.com/topic/22313/c-solution-using-bit-manipulation
	 * 
	 */
	public int missingNumber(int[] nums) {
		return 0;
    }
}
