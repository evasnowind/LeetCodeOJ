package solution.lc_198_house_robber;

public class Solution {
	/*
	 * 下面这种递归实现能解题，但leetcode报Time Limit Exceeded
	public int rob(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
        return getMaxProfit(nums, 0);
    }
	
	private int getMaxProfit(int[] nums, int idx){
		if(idx >= nums.length){
			return 0;
		} else {
			int sum1 = nums[idx];
			if((idx+2) < nums.length){
				sum1 += getMaxProfit(nums, idx+2);
			}
			int sum2 = 0;
			if((idx+1) < nums.length){
				sum2 = nums[idx+1];
			}
			if((idx+3) < nums.length){
				sum2 += getMaxProfit(nums, idx+3);
			}
			return Math.max(sum1, sum2);
		}
	}
	*/
	
	/*
	 * 采用动态规划（DP）结题，记录每步抢、不抢所得金额，供下一步计算，因此可以得到如下解
	 * 参见：https://discuss.leetcode.com/topic/11082/java-o-n-solution-space-o-1
		public int rob(int[] num) {
		    int[][] dp = new int[num.length + 1][2];
		    for (int i = 1; i <= num.length; i++) {
		    //dp[i][1] means we rob the current house and dp[i][0] means we don't,
		        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
		        dp[i][1] = num[i - 1] + dp[i - 1][0];
		    }
		    return Math.max(dp[num.length][0], dp[num.length][1]);
		}
	 * 实际计算时我们只需要保存上一步的值，因此没必要用一个矩阵，优化后得到下面算法：
	 */
	public int rob(int[] nums) {
		int prevNo = 0;//不抢当前屋子所得最大值
	    int prevYes = 0;//抢当前屋子所得最大值
	    for (int n : nums) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);//不抢当前，则最大值应为上个屋子抢、不抢所得最大值
	        prevYes = n + temp;//抢当前，则最大值应为上个屋子不抢+当前屋子
	    }
	    return Math.max(prevNo, prevYes);
    }
}
