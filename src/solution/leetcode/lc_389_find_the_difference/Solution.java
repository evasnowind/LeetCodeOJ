package solution.leetcode.lc_389_find_the_difference;

public class Solution {
	/*
	 * 由于可能出现所有字母都出现、但t中出现次数一次的情况，因此不能使用
	 * set这种数据结构，必须记录每个字母的出现次数。可以用数组、hashmap，
	 * 也可以使用位运算，利用异或的特性，参见：https://discuss.leetcode.com/topic/55912/java-solution-using-bit-manipulation
	 */
	public char findTheDifference(String s, String t) {
		int[] alpha = new int[26];
		for(char ch : s.toCharArray()){
			alpha[ch - 'a'] += 1; 
		}
		
		for(char c : t.toCharArray()){
			alpha[c - 'a'] -= 1;
			if(alpha[c - 'a'] < 0){ 
				return c;
			}
		}
		return 0;
    }
}
