package solution.oj_27_remove_element;

public class Solution {
	/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

	分析：本题和26 Remove Duplicates from Sorted Array很类似，题目都要求不用额外的空间，而这可以
	利用数组本身“无用的”部分来存储中间结果，最后得到所求。
	
	就本题而言，题目中已经提到可以最终结果可以乱序，那么就有如下解法
	参考：
	
	如果要求最终结果顺序要和初始数组保持一致，那就需要利用两个索引，一个索引cur指向当前满足条件的数字，
	一个索引next指向后面实际已经遍历到的数字，不断将next所指的数字往cur位置挪、cur不断更新即可。
	 * 
	 */
	public int removeElement(int[] nums, int val) {
		if(null == nums || nums.length == 0) return 0;
        int pivot = nums.length;
        int i = 0; 
        while(i < pivot){
        	if(nums[i] == val) {
        		nums[i] = nums[pivot-1];
        		pivot--;
        	} else {
        		i++;
        	}
        }
		return pivot;
    }

    public int removeElement2(int[] nums, int val) {
		if(null == nums || nums.length == 0) {
			return 0;
		}

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if(nums[j] != val) {
				nums[i] = nums[j];
				i += 1;
			}
		}
		return i;
	}
}
