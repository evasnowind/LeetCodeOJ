package oj_8_string_to_integer;

public class Solution {
	public int myAtoi(String s) {
		if(s == null || s.trim().equalsIgnoreCase("")) {
			return 0;
		}
		String str = s.trim();
		int sign = 1, i = 0, result = 0;
		char[] chars = str.toCharArray();
		if(chars[i] == '+' || chars[i] == '-') {
			sign = chars[i++]=='-'? -1 : 1;
		}
		while(i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
			if((result > Integer.MAX_VALUE / 10) 
					|| (result == Integer.MAX_VALUE / 10 && (chars[i] - '0' > 7))){
				return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			result = result * 10 + chars[i++] - '0';
		}
		return result * sign;
    }
}
