package oj_solution.oj_7_reverse_integer;

public class Solution {
	/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
	 */
	public int reverse(int x) {
		int result = 0;
		int sign = x>0? 1:-1;
		int tmp = Math.abs(x);

        while(tmp != 0){
        	int rtmp = (Integer.MAX_VALUE - tmp % 10)/10;
        	if(rtmp < result) {
        		return 0;
        	}
        	result = result*10 + tmp % 10;
        	tmp = tmp / 10;
        };
        
        return sign * result;
    }
}
 