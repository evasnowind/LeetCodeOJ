package oj_solution.oj_191_number_of_1_bits;

public class Solution {
	// you need to treat n as an unsigned value
	/*
	 * 经典面试题
	 * 各种计算数字中1个数的算法参见 http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
	 * 
	 * 扩展阅读：https://en.wikipedia.org/wiki/Hamming_weight
	 */
    public int hammingWeight(int n) {
    	int cnt = 0;
    	while(n != 0){
    		n = n & (n-1);
    		cnt += 1;
    	}
        return cnt;
    }
}
