package solution.oj_162_find_peak_element;

public class Solution {
	/*
	 * 分析：题目要求时间复杂度为O(lgn)级别，并且输入是一个数组，很容易想到
	 * 		应该借鉴二分查找算法，并且题目给出了num[-1] = num[n] = -∞ ,
	 * 		变相提示了有关num[0]  num[n-1]需要分别处理。在单独处理了num[0]  num[n-1]
	 * 		之后，中间的部分即可采用二分思路来找，输入数据需要判断的有3种情况，
	 * 		参见 https://discuss.leetcode.com/topic/5848/o-logn-solution-javacode
	 * 		
	 * 另一种思路：递归求解数组最大值，同样是O(lgn)
	 * 		参考 https://discuss.leetcode.com/topic/5724/find-the-maximum-by-binary-search-recursion-and-iteration
	 */
	public int findPeakElement(int[] nums) {
		if(null == nums || 0 == nums.length) return 0;
		if(nums.length == 1) return 0;
		if(nums[0] > nums[1]) return 0;
		if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
		int low = 0, high = nums.length, mid = 0;
		while(low < high){
			mid = low + (high - low) / 2;
			if(nums[mid] < nums[mid + 1]){
				low += 1;
			} else if(nums[mid] < nums[mid - 1]){
				high -= 1;
			} else {
				return mid;
			}
		}
		return 0;
    }
}
