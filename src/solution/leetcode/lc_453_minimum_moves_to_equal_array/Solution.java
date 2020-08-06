package solution.leetcode.lc_453_minimum_moves_to_equal_array;

public class Solution {

	/*
	 * 声明：本题我是没做出来，想不通，直接看的discuss分析与网上的分析
	 * 
	 * 这道题给了我们一个长度为n的数组，说是我们每次可以对n-1个数字同时加1，
	 * 问最少需要多少次这样的操作才能让数组中所有的数字相等。那么我们想，
	 * 为了快速的缩小差距，该选择哪些数字加1呢，不难看出每次需要给除了数组
	 * 最大值的所有数字加1，这样能快速的到达平衡状态。但是这道题如果我们
	 * 老老实实的每次找出最大值，然后给其他数字加1，再判断是否平衡，
	 * 思路是正确，但是OJ不答应。正确的解法相当的巧妙，需要换一个角度来看问题，
	 * 其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，比如数组[1，2，3],
	 * 给除去最大值的其他数字加1，变为[2，3，3]，我们全体减1，并不影响数字间
	 * 相对差异，变为[1，2，2]，这个结果其实就是原始数组的最大值3自减1，
	 * 那么问题也可能转化为，将所有数字都减小到最小值，这样难度就大大降低了，
	 * 我们只要先找到最小值，然后累加每个数跟最小值之间的差值即可
	 * 
	 * 上面分析摘自：http://www.cnblogs.com/grandyang/p/6053827.html
	 * 
	 * 其他参考：https://discuss.leetcode.com/topic/66557/java-o-n-solution-short
	 * 
	 * 每次move转换成对某个数字减1后，每个数-min所获得的仅仅是这个数到达min所需要的
	 * move次数，而每个数都会进行move操作，因此需要累加
	 * 
	 */
	public int minMoves(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
		int min = nums[0];
		for(int n:nums){
			min = Math.min(min, n);
		}
		int res = 0;
		for(int n:nums){
			res += n - min;
		}
		return res;
    }
}
