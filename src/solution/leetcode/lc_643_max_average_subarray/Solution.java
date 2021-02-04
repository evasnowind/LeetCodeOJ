package solution.leetcode.lc_643_max_average_subarray;

/**
 * @author chenglong.yu
 * created on 2021/2/4
 */
public class Solution {


    public double findMaxAverage(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k > nums.length) {
            return 0;
        }

        int curSum = 0, maxSum = 0;
        for(int i = 0; i < k; i++) {
            curSum += nums[i];
        }

        maxSum = curSum;

        for(int i = k; i < nums.length; i++) {
            curSum = curSum - nums[i - k] + nums[i];
            maxSum = Math.max(curSum, maxSum);
        }

        //注意此处必须有1.0*这个步骤，否则除法将会按照整数除法，将会省略掉小数！
        return 1.0 * maxSum / k;
    }
}
