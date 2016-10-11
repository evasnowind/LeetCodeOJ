package oj_solution.oj_349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	/*
	 * 分析：简单思路，空间换时间，用set来存一个数组，遍历另一个数组，缺点：数据量大时占用空间大
	 * 
	 * 其他思路：
	 * 	1、两个数组先排序，然后同步遍历，若相等则保存起来 O(nlgn)
	 * 	2、先给一个数组排序，将问题转换为，在一个有序数组中，查找另一个数组中的所有元素，然后查找 O(nlgn)
	 * 具体实现参见https://discuss.leetcode.com/topic/45685/three-java-solutions
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
		Set<Integer> interSet = new HashSet<Integer>();
		Set<Integer> numsSet = new HashSet<Integer>();
		for(int n:nums1){
			numsSet.add(n);
		}
		for(int m:nums2){
			if(numsSet.contains(m)){
				interSet.add(m);
			}
		}
		int[] res = new int[interSet.size()];
		int idx = 0;
		for(Integer num:interSet){
			res[idx++] = num;
		}
		return res;
    }
}
