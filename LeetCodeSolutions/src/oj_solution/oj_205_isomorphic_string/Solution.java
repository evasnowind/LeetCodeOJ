package oj_solution.oj_205_isomorphic_string;

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
}
