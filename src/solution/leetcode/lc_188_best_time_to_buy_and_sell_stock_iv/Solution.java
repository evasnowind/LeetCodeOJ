package solution.leetcode.lc_188_best_time_to_buy_and_sell_stock_iv;

import java.net.Socket;

/**
 * @author chenglong.yu
 * created on 2020/8/22
 */
public class Solution {

    /*
    取自：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
     */
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k+1][2];
        int res = 0;
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j][1]+prices[i]);
                //处理第k次买入
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0]-prices[i]);
            }
        }
        return dp[k][0];
    }

    public int maxProfitWithInfiniteK(int[] prices) {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxProfit(1, new int[]{1,2});
    }
}
