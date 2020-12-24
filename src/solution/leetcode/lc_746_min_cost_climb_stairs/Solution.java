package solution.leetcode.lc_746_min_cost_climb_stairs;

/**
 * @author chenglong.yu
 * created on 2020/12/21
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        /*
        dp[i]表示到达下标i的台阶时，所需要花费的最小值
        则有状态转移公式：
        dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        即，要么时候从i-1台阶，花费cost[i-1]到达i, 要么是从i-2台阶，花费cost[i-2]到达i
        迭代到最后一个台阶即为所求。
         */
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }

    /**
     * 使用滚动数组的思想，减小空间消耗，最终时间O(N) O(N)
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int pre = 0, cur = 0;
        for(int i = 2; i <= n; i++) {
            int next = Math.min(pre + cost[i-2], cur + cost[i-1]);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}
