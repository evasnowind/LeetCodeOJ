package solution.leetcode.lc_344_reverse_string;

public class Solution {
	public String reverseString(String s) {
		if(null == s || "".equalsIgnoreCase(s.trim())) return s;
		int len = s.length();
		char[] str = new char[len];
		for(int i = 0; i < len; i++){
			str[i] = s.charAt(len - 1 - i);
		}
		return String.valueOf(str);
    }

	public void reverseString(char[] s) {
		if (null == s) {
			return;
		}

		int len = s.length;
		for (int i = 0; i < len / 2; i++) {
			char tmpCh = s[s.length - i - 1];
			s[s.length - i - 1] = s[i];
			s[i] =tmpCh;
		}
	}
}
