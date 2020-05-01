package solution.oj_153_find_minimum_in_rotated_sorted_array;

public class Solution {
	/*
	 * 
	 * 思想：二分法的关键就是在最开始思考时，从整体把握，分好段，看清楚
	 * 		是有哪几种情况，不要马上就钻入细节，容易迷失
	 * 
	 * 参考：题目更详细解说 https://discuss.leetcode.com/topic/14768/4ms-simple-c-code-with-explanation
	 * 
	 * nums[mid] > nums[high] 说明最小值在后半段，否则说明在前半段
	 * 
	 * 最后结果不一定是nums[mid]，如[2,1]，而是在nums[low]
	 * 
	 * 由于是找最小值，必然能找到一个结果
	 * 
	 * 注：本题没说清的一点是，sorted实际上就是指从小到大排序
	 */
	public int findMin(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
		int mid=0;
		int low = 0;
		int high = nums.length - 1;
		while(low < high){
			mid = low + (high - low)/2;
			if(nums[mid] > nums[high]){
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return nums[low];
    }
}
