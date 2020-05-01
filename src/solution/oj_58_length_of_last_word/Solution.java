package solution.oj_58_length_of_last_word;

public class Solution {
	/*
https://leetcode.com/problems/length-of-last-word/?tab=Description

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
	 * 
	 * 
	 * 参考：https://discuss.leetcode.com/topic/6055/a-single-line-of-code-in-java
	 * 这种方式很简单，但可能和leetcode初衷相左，毕竟leetcode主要考察算法实现，可以参考如下
	 * https://discuss.leetcode.com/topic/17312/7-lines-4ms-c-solution
	 * 这个solution思路很简单：先从后往前找到第一个' '，然后再从前往后数即可
	 * 
	 */
	public int lengthOfLastWord(String s) {
		if(null == s || "".equals(s.trim())) return 0;
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
