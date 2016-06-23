package oj_solution.oj_28_implement_strStr;

public class Solution {
	public int strStr(String haystack, String needle) {
		if(null == haystack || null == needle) return -1;
		/*
		 * TODO 其实没啥好的解法，直接遍历就是了，不过也许可以参考一下KMP算法？
		 */
		for(int i = 0; ; i++) {
			for(int j = 0; ; j++){
				if(j == needle.length()) return j;
				if((i+j) >= haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) break;
			}
		}
	}
}
