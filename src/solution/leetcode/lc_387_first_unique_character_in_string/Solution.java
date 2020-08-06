package solution.leetcode.lc_387_first_unique_character_in_string;

public class Solution {
	/*
	 * 比较简单的题目，用空间换时间 
	 */
	public int firstUniqChar(String s) {
		if(null == s) return -1;
		int[] chs = new int[26];
		int len = s.length();
		for(int i = 0; i < len; i++){
			chs[s.charAt(i) - 'a'] += 1;
		}
		int res = -1;
		for(int i = 0; i < len; i++){
			if(chs[s.charAt(i) - 'a'] == 1){
				res = i;
				break;
			}
		}
        return res;
    }
}
