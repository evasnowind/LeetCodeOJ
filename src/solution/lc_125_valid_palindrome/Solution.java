package solution.lc_125_valid_palindrome;

public class Solution {

	public boolean isPalindrome(String s) {
		if (null == s) {
			return false;
		}
		if ("" == s) {
			return true;
		}

		char[] chs = s.trim().toCharArray();
		int left = 0, right = chs.length - 1;
		boolean res = true;
		while(left < right) {
			while(left < right && !Character.isLetterOrDigit(chs[left])) {
				left += 1;
			}
			while(left < right && !Character.isLetterOrDigit(chs[right])) {
				right -= 1;
			}
			if (left < right && Character.toLowerCase(chs[left]) != Character.toLowerCase(chs[right])) {
				res = false;
				break;
			}
			left += 1;
			right -= 1;
		}
		return res;
    }
}
