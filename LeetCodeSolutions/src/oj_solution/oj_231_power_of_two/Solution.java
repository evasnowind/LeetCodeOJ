package oj_solution.oj_231_power_of_two;

public class Solution {
	/*
	 * 除了循环、递归，还可以考虑用位运算，2的乘方必然只有1个1、其他都是0（1，10，100，1000……），因此
	 * 有如下解法：
	 * 
	 * bool isPowerOfTwo(int n) {
        return (n>0&&((n&(n-1))==0));
    	}
	 */
	/*
	 * 注意考虑0 、1等特殊情况
	 */
	public boolean isPowerOfTwo(int n) {
		if(0 >= n) return false;
		boolean result = true;
		while(n != 1){
			if(n % 2 != 0){
				result = false;
				break;
			}
			n = n/2;
		}
		return result;
    }
}
