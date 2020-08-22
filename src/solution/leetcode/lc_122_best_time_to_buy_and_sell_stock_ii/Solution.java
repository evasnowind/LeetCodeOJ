package solution.leetcode.lc_122_best_time_to_buy_and_sell_stock_ii;

public class Solution {


    /**
    https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/tuan-mie-gu-piao-wen-ti
     属于k 交易次数无限制的情况

     如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。可以这样改写框架：
     dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

     我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])

     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        //dp[i][0]
        int dpHasNoStock = 0;
        //dp[i][1] 设置为Integer.MIN_VALUE 表示一开始不可能拥有股票，必须先买后卖
        int dpHasStock = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dpHasNoStock;
            dpHasNoStock = Math.max(dpHasNoStock, dpHasStock + prices[i]);
            dpHasStock = Math.max(dpHasStock, tmp - prices[i]);
        }
        return dpHasNoStock;
    }
}
