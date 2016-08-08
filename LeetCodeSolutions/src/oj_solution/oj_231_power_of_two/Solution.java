package oj_solution.oj_231_power_of_two;

public class Solution {
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
