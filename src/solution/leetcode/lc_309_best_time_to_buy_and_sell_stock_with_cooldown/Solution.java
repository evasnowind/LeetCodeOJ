package solution.leetcode.lc_309_best_time_to_buy_and_sell_stock_with_cooldown;

/**
 * @author chenglong.yu
 * created on 2020/8/24
 */
public class Solution {

    /*
    没有冷冻期、容许无限次交易的状态转移：
        https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/tuan-mie-gu-piao-wen-ti
     属于k 交易次数无限制的情况

     如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
     dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

     我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

     由于有了冷冻期，需要修改为：
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
    即：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        //dp[i-2][0]
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }
}
