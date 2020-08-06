package solution.leetcode.lc_345_reverse_vowels_of_strings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	/*
	 * 简单题，弄明白题目意思即可（个人觉得题目例子没说清……我参考https://discuss.leetcode.com/topic/43412/java-standard-two-pointer-solution 才整明白）
	 * 思路：两头找即可
	 */
	public String reverseVowels(String s) {
		if(null == s || s.length() == 0) return s;
		Set<Character> vowelSet = new HashSet<Character>();
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');
		vowelSet.add('A');
		vowelSet.add('E');
		vowelSet.add('I');
		vowelSet.add('O');
		vowelSet.add('U');
		char[] strChs = s.toCharArray();
		int start = 0, end = strChs.length - 1;
		while(start < end){
			while(start < end && !vowelSet.contains(strChs[start])){
				start+=1;
			}
			while(start < end && !vowelSet.contains(strChs[end])){
				end-=1;
			}
			char tmp = strChs[start];
			strChs[start] = strChs[end];
			strChs[end] = tmp;
			start+=1;
			end-=1;
		}
		return new String(strChs);
    }
}
