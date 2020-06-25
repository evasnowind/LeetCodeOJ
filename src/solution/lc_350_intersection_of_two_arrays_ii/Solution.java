package solution.oj_350_intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	/*
	 * 分析：直观思路，先保存一个队列，然后用遍历另一个队列
	 * 针对性分析
	 * 	（1）给定数组已排序：同时遍历两个数组 Time: O(max(m, n) log(max(m, n))) Space: O(m + n) 参见https://discuss.leetcode.com/topic/45893/c-hash-table-solution-and-sort-two-pointers-solution-with-time-and-space-complexity/2
	 * 	（3）数据排序，但只能部分放入内存：分块比较 https://discuss.leetcode.com/topic/45992/solution-to-3rd-follow-up-question
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int n:nums1){
        	if(map.containsKey(n)){
        		map.put(n, map.get(n)+1);
        	} else {
        		map.put(n,1);
        	}
        }
        for(int m:nums2){
        	if(map.containsKey(m) && map.get(m) > 0){
        		res.add(m);
        		map.put(m,map.get(m)-1);
        	}
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
        	r[i] = res.get(i);
        }
		return r;
    }
}
