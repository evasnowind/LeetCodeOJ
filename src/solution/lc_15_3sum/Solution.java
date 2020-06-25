package solution.oj_15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	/*
	 * 分析：先排序，然后先确定一个元素，后续两个元素用二分思想查找。
	 * 		题目要求的三元组要求唯一，则可以根据第一个元素区分，并且
	 * 		查找时注意还有第一个元素相同、后两个元素不同的情况，即可保证
	 * 		找到所有
	 * 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		//此处碰到一个比较诡异的问题，如果我在排序前添加一个if判断，当nums是空或是长度为0则直接
		//返回（返回下面这个res）的判断，则超时报错……
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		for(int i = 0; i < nums.length - 2; i++){
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
				int low = i+1, high = nums.length - 1, sum = 0 - nums[i];
				while(low < high){
					if(nums[low] + nums[high] == sum){
						res.add(Arrays.asList(nums[i],nums[low], nums[high]));
						//找到一个结果，但后续还有可能后两个元素不相等的情况
						while(low < high && nums[low] == nums[low+1]) low += 1;
						while(low < high && nums[high] == nums[high-1]) high -= 1;
						low += 1;
						high -= 1;
					}else if((nums[low] + nums[high]) < sum){
						low += 1;
					} else {
						high -= 1;
					}
				}
			}
		}
        return res;
    }
}
