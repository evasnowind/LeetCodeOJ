package solution.leetcode.lc_300_longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/9/10
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //定义dp数组，dp[i]存放着对应nums数组中以nums[i]结尾的区间nums[0..i]的最长上升子序列长度
        int[] dp = new int[n];
        //每个位置的最长上升子序列最小也为1，即他自身（比如递减序列），可以填充为1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    /*
                    此处的判断是核心：
                    nums[0...j]这个区间中，可能有多个子序列，我们的目标是求最长，
                    因此dp[j]保存着nums[0...j]这个区间中以nums[j]结尾的最长子序列的长度，即有
                    dp[j]个元素，是单调递增的，且这个区间最大元素为nums[j]。
                    如果nums[i] > nums[j]， 那么表明可以追加上nums[i]后、组成一个
                    以nums[i]结尾、最长子序列的长度为dp[j] + 1 的区间。
                     */
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
