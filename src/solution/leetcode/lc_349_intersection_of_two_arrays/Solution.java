package solution.leetcode.lc_349_intersection_of_two_arrays;

import java.util.Arrays;
import java.util.HashSet;
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
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
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

    public int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int len1 = nums1.length, len2 = nums2.length;
		int[] intersaction = new int[len1 + len2];
		int index = 0, index1 = 0, index2 = 0;
		while(index1 < len1 && index2 < len2) {
			int num1 = nums1[index1];
			int num2 = nums2[index2];
			if (num1 == num2) {
				if (index == 0 || intersaction[index-1] != num1) {
					//第0个元素不可能重复；否则就需要判断是否与前一个元素是否重复
					intersaction[index++] = num1;
				}
				index1++;
				index2++;
			} else if (num1 < num2) {
				index1++;
			} else {
				index2++;
			}
		}
		return Arrays.copyOfRange(intersaction, 0, index);
	}
}
