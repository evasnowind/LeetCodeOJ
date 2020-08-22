package solution.leetcode.lc_123_best_time_to_buy_and_sell_stock_iii;

/**
 * @author chenglong.yu
 * created on 2020/8/22
 */
public class Solution {

    /**

     原始的动态转移方程，没有可化简的地方
     dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     最多可以完成两笔交易，k<=2

     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        //由于交易次数有限制、状态转移方程无法化简，k的引入导致额外添加一个循环，以便遍历完所有状态
        int maxK = 2;
        int[][][] dp = new int[n][maxK + 1][2];

        dp[0][0][0] = 0;
        //没有交易、但拥有股票，显然是不可能的情况，直接用Integer.MIN_VALUE即可
        dp[0][0][1] = Integer.MIN_VALUE;
        //一次交易、没有股票
        dp[0][1][0] = 0;
        //严格来讲我觉得dp[0][1][1]   dp[0][2][1] 所代表的情况不会发生，此处只是为了能按照状态转移关系、保证计算的简洁、强行加了
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int k = 1; k < maxK + 1; k++) {
                //已经完成了k次交易、已不再持有股票，或是 第k次刚买入、需要卖出，所以此处dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                //第k买入、但尚未卖出股票，或是 第k-1次卖出后、第k次买入，所以此处dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }

        return dp[n-1][maxK][0];
    }
}
