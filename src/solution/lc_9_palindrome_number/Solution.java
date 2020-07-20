package solution.lc_9_palindrome_number;

public class Solution {
	/*
Determine whether an integer is a palindrome. Do this without extra space.
	 */

	public boolean isPalindrome(int x) {
		if(x < 0)  {
			return false;
		}
		int n = 0, y = x;
		while(y != 0) {
			n = n * 10 + y % 10;
			y = y / 10;
		}
        return x == n;
    }

	/**
	 * 思路取自  https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome2(int x) {
		//0. 根据定义，负数不可能是回文数，直接返回
		if (x < 0) {
			return false;
		}
		//1. 先计算出最高位对应的整数，以便取整。注意边界条件
		int div = 1;
		int tmpX = x;
		while (tmpX >= 10) {
			div = div * 10;
			tmpX = tmpX / 10;
		}

		/**
		 2. 循环，比较数字两边是否一致，不一致返回false；若一致，则继续比较下一个数字。
		 注意，比较下一个数字时，需要剔除掉最高位、最低位两个数字，需要先取余div去掉首位、然后再除以10去掉末尾。
		 因此，终止条件是tmpX变成0
		 */


		int left = 0, right = 0;
		while(x > 0) {
			left = x / div;
			right = x % 10;
			if (left != right) {
				return false;
			}

			x = (x % div) / 10;
			div = div / 100;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.isPalindrome2(1221));
		System.out.println(s.isPalindrome2(1001));

	}
}
