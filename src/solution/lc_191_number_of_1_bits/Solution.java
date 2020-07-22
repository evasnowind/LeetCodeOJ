package solution.lc_191_number_of_1_bits;

public class Solution {
	// you need to treat n as an unsigned value
	/*
	 * 经典面试题
	 * 各种计算数字中1个数的算法参见 http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
	 *
	 * 对于任意数字 nn ，将 nn 和 n - 1n−1 做与运算，会把最后一个 11 的位变成 00 。
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

    public int hammingWeight2(int n) {
    	int mask = 1;
    	int sum = 0;
		for (int i = 0; i < 32; i++) {
			if((n & mask) != 0) {
				sum += 1;
			}
			mask = mask << 1;
		}

		return sum;
	}
}
