package oj_solution.oj_326_power_of_three;

public class Solution {
	/*
	 * 思路：用循环或是递归，每次判断是否整除，但题目说还有其他思路，我看了discuss
	 * 		才想到……见 https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th
	 */
	public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
