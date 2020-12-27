package solution.leetcode.lc_205_isomorphic_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	 * 分析：简单思路，直接创建一个hashmap，同时遍历两个字符串，获得映射关系
	 * (遍历过程中若发现有一个字母映射到两个不同字母的情况则直接false)，
	 * 	
	 * 然后再次遍历第一个字符数组，根据映射表创建新的字符串，该串与第二个串完全
	 * 一样则true，否则就是false
	 * 
	 * 但上述方面时间O(N) 空间O(N)（因为要创建新的字符串）
	 * 
	 * 优化后：遍历过程中将位置信息保存起来，比较每个字母的位置，字母个数固定（扩展ASCII有256），
	 * 		空间消耗是常量
	 * 		同构字符串：不论字母是否重复，对应字母的位置信息都是一样的，同步更新
	 * 		非同构字符串：两个串字母都不重复，则是同构的（即使有相同字母）；一般不同构的是
	 * 					一个串有重复字母一个没有，那么此时位置信息会有不同的情况
	 * 		
	 */
	public boolean isIsomorphic(String s, String t) {
		int[] sMarks = new int[256],tMarks = new int[256];
		for(int i = 0; i < s.length(); i++){
			if(sMarks[s.charAt(i)] != tMarks[t.charAt(i)]){
				return false;
			} else {
				sMarks[s.charAt(i)] = i+1;
				tMarks[t.charAt(i)] = i+1;
			}
		}
		return true;
    }

	public boolean isIsomorphic2(String s, String t) {
		if (null == s || s.length() == 0) {
			return true;
		}
		char[] ch1 = s.toCharArray();
		char[] ch2 = t.toCharArray();

		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < ch1.length; i++) {
			if (map.containsKey(ch1[i])) {
				char val = map.get(ch1[i]);
				if (val != ch2[i]) {
					return false;
				} else {
					continue;
				}
			} else if (map.containsValue(ch2[i])) {
                /*
                在第一步if 判断map中key是否存在映射关系后，
                还需要判断value中已经有映射到ch2[i]的映射关系。
                如果有，那么说明之前已经出现过一个字符映射到
                ch2[i]，而现在又有一个新的字符映射到ch2[i]。
                那么也应该返回false
                 */
				return false;
			} else {
				map.put(ch1[i], ch2[i]);
			}
		}

		return true;
	}


	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.isIsomorphic("egg", "add"));
		System.out.println(s.isIsomorphic("foo", "bar"));
		System.out.println(s.isIsomorphic("paper", "title"));
		System.out.println(s.isIsomorphic("ab", "aa"));

	}
}
