package solution.oj_344_reverse_string;

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
}
