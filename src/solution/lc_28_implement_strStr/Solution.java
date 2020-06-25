package solution.lc_28_implement_strStr;

public class Solution {
	/*
	 * 

https://leetcode.com/problems/implement-strstr/?tab=Description

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


	 */
	public int strStr(String haystack, String needle) {
		if(null == haystack || null == needle) return -1;
		/*
		 * TODO 其实没啥好的解法，直接遍历就是了，不过也许可以参考一下KMP算法？
		 * 
		 */
		for(int i = 0; ; i++) {
			for(int j = 0; ; j++){
				if(j == needle.length()) return j;
				if((i+j) >= haystack.length()) return -1;
				if(needle.charAt(j) != haystack.charAt(i+j)) break;
			}
		}
	}

	public int strStr2(String haystack, String needle) {
		if(null == haystack || null == needle) return -1;
		return haystack.indexOf(needle);
	}
}
