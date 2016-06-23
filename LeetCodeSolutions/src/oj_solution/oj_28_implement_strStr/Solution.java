package oj_solution.oj_28_implement_strStr;

public class Solution {
	public int strStr(String haystack, String needle) {
		if(null == haystack || null == needle) return -1;
		for(int i = 0; ; i++) {
			for(int j = 0; ; j++){
				if(j == needle.length()) return j;
				if((i+j) >= haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) break;
			}
		}
	}
}
