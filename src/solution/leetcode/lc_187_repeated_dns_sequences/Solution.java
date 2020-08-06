package solution.leetcode.lc_187_repeated_dns_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	/*
	 * 参考 https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation
	 * 分析：直观思路是保存每个字串到一个集合中，每次保存时即可知道是否重复，
	 * 		但直接保存字符串空间消耗太大，所以将字符串编码，用两位二进制数
	 * 		代表一个DNA字母，如此一个10字母的字符串可以用一个int表示。下面
	 * 		代码用两个set，第一个用于判断是否重复，第二个用于判断是否之前已经
	 * 		保存了这个结果
	 * 
	 * 另一种优化思路：https://discuss.leetcode.com/topic/8487/i-did-it-in-10-lines-of-c/2
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
		if(null == s) return res;
		Set<Integer> words = new HashSet<Integer>();
		Set<Integer> doubleWords = new HashSet<Integer>();
		int[] codeMap = new int[26];
		//codeMap['A'-'A'] = 0; is default
		codeMap['C'-'A'] = 1;
		codeMap['G'-'A'] = 2;
		codeMap['T'-'A'] = 3;
		for(int i = 0; i < s.length() - 9; i++){
			int code = 0;
			for(int j = i; j < i+10; j++){
				code <<= 2;
				code |= codeMap[s.charAt(j) - 'A'];
			}
			if(!words.add(code) && doubleWords.add(code)){
				res.add(s.substring(i, i+10));
			}
		}
        return res;
    }
}
