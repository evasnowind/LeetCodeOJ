package oj_solution.oj_66_plus_one;

public class Solution {
	/*
	 * 题目意思是给digits所表示的数加1，但digits从最高位元素表示低位数
	 */
	public int[] plusOne(int[] digits) {
		if(null == digits) return null;
		if(0 == digits.length) {
			digits = new int[1];
			digits[0] = 1;
			return digits;
		}
		int[] result = digits;
		int idx = digits.length - 1;
		digits[idx] = digits[idx]+1;
		while(idx >= 0 && digits[idx] >= 10) {
			if(idx== 0) {
				int[] copyNums = new int[digits.length + 1];
				System.arraycopy(digits, 0, copyNums, 1, digits.length);
				copyNums[0] = copyNums[1]/10;
				copyNums[1] = copyNums[1]%10;
				result = copyNums;
				break;
			}else {
				digits[idx-1] = digits[idx-1]+digits[idx]/10;
				digits[idx] = digits[idx]%10;
				idx--;
			}
		}
		return result;
    }
}
