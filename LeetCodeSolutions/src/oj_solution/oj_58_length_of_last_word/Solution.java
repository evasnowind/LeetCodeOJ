package oj_solution.oj_58_length_of_last_word;

public class Solution {
	public int lengthOfLastWord(String s) {
		if(null == s || "".equals(s.trim())) return 0;
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
