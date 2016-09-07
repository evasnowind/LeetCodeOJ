package oj_solution.oj_121_best_time_to_buy_and_sell_stock;

public class Solution {
	/*
	 * 分析：直观思路是双重循环，遍历所有可能解，但还能继续优化，
	 * 		由于题目是想计算最大差值，那么可以在遍历过程中找到价格最小值、
	 * 		当前利益最大值
	 * 
	 * 另一种思路：https://discuss.leetcode.com/topic/19853/kadane-s-algorithm-since-no-one-has-mentioned-about-this-so-far-in-case-if-interviewer-twists-the-input
	 */
	public int maxProfit(int[] prices) {
		int res = 0;
		if(null == prices) return res;
		int minPrice = Integer.MAX_VALUE, maxProfit = 0;
		for(int i = 0; i < prices.length; i++){
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
        return maxProfit;
    }
}
