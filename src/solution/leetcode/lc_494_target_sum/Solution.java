package solution.leetcode.lc_494_target_sum;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/9/19
 */
public class Solution {

    private int solutionCnt = 0;
    private int[] method = new int[]{1, -1};

    public int findTargetSumWays(int[] nums, int S) {
        //已规定输入范围不为空，不用判断空的情况

        calculate(nums, 0, 0, S);
        return solutionCnt;
    }

    private void calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (target == sum) {
                solutionCnt++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], target);
            calculate(nums, i + 1, sum - nums[i], target);
        }
    }

    /**
     * 分析参见
     作者：LeetCode
     链接：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     来源：力扣（LeetCode）

     * @param nums
     * @param S
     * @return
     */
    public int  findTargetSumWays2(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int cnt = s.findTargetSumWays(nums, target);
        System.out.println(cnt);
    }
}
