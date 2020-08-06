package solution.leetcode.lc_258_add_digits;

public class Solution {
	/*
	 * 
	 * 如果用直观思路，直接按照题目要求计算，很容易写出算法，但运行时间较长
	 * 
	 * 但本题是经典的digital root问题，参见https://en.wikipedia.org/wiki/Digital_root
	 * 
	 * https://discuss.leetcode.com/topic/21498/accepted-c-o-1-time-o-1-space-1-line-solution-with-detail-explanations
	 * 
	 * 
	 * For base b (decimal case b = 10), the digit root of an integer is:

			dr(n) = 0 if n == 0
			dr(n) = (b-1) if n != 0 and n % (b-1) == 0
			dr(n) = n mod (b-1) if n % (b-1) != 0
			or
			
			dr(n) = 1 + (n - 1) % 9  
Note here, when n = 0, since (n - 1) % 9 = -1, the return value is zero (correct).

From the formula, we can find that the result of this problem is immanently periodic, with period (b-1).

Output sequence for decimals (b = 10):

~input: 0 1 2 3 4 ...
output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ....

Henceforth, we can write the following code, whose time and space complexities are both O(1).

	使用上面公式，对于十进制，
	   dr(n) = 1 + (n - 1) % 9
	
	 */
	
	public int addDigits(int num) {
		return 1 + (num - 1) % 9;
    }
}
