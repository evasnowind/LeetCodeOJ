package oj_solution.oj_190_reverse_bits;

public class Solution {
	/*
	 * 分析：注意仔细读题，弄明白意思，位的逆转操作与int数不一样，int数逆转
	 * 		操作次数等于int数所含的数字个数，位逆转则需要将整个int数里的所有
	 * 		位都逆序，一般int都是32位，因此必须转换32次。
	 * 优化：
	 */
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int res = 0;
    	for(int i = 0; i < 32; i++){
    		res = res << 1;
    		res += n & 1;
    		n = n >>> 1;
    	}
    	return res;
    }
}
