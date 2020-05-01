package solution.oj_455_assign_cookies;

import java.util.Arrays;

public class Solution {
	/*
	 * 分析：解题思路很明显，先排序，然后从小到大，依次满足每个孩子的
	 * 		需求，直到遍历完毕或是不能满足任何孩子的需求
	 * 
	 * 注：由于已经排序，因此记录上一次遍历到s中的哪个位置（pointS），说明在这之前
	 * 		的饼干已经分配，pointS加1即为当前尚未分配的、最小的饼干。
	 * 代码来自： https://discuss.leetcode.com/topic/68455/array-sort-two-pointer-greedy-solution-o-nlogn
	 * 
	 * 相比之下，https://discuss.leetcode.com/topic/67676/simple-greedy-java-solution 
	 * 这个帖子中贴出的代码每次从s的第一位置开始遍历，是错误的，可能会造成一个
	 * 饼干分给多个孩子的情况
	 * 
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        
        int pointG = 0;
        int pointS = 0;
        
        while (pointG<g.length && pointS<s.length) {
            if (g[pointG]<=s[pointS]) {
                pointG++;
                pointS++;
            } else {
                pointS++;
            }
        }
        return pointG;
    }
}
