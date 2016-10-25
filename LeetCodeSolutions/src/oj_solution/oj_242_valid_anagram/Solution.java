package oj_solution.oj_242_valid_anagram;

public class Solution {
	/*
	 * 分析：注意看清题目即可，部分字母颠倒顺序，并不一定是全部颠倒。
	 * 		若是unicode的情况，使用hash表即可
	 */
	public boolean isAnagram(String s, String t) {
		if(null == s && null == t) return true;
		if(null != s && null != t){
			if(s.length() != t.length()) return false;
			int[] alphabet = new int[26];
	        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
	        for (int i : alphabet) if (i != 0) return false;
	        return true;
		} else {
			return false;
		}
    }
}
