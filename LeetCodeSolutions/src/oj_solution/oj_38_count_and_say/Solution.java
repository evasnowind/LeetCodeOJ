package oj_solution.oj_38_count_and_say;

public class Solution {
	/**
	 * 找规律题：第n个数字是从头到尾数第n-1个数字中每个
	 * 数字各有多少个，比如第3个数字“21”是数“11”：有2个“1”，因此是21
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if(0 == n) {
			return "";
		} else if(1 == n) {
			return "1";
		} else {
			String lastStr = countAndSay(n-1);
			StringBuilder builder = new StringBuilder();
			int i = 0; 
			int cnt = 0;
			char ch = '0';
			while(i < lastStr.length()) {
				ch = lastStr.charAt(i);
				cnt = 1;
				i++;
				while(i < lastStr.length() && lastStr.charAt(i) == ch){
					cnt++;
					i++;
				}
				builder.append(cnt).append(ch);
			}
			return builder.toString();
		}
    }
}
