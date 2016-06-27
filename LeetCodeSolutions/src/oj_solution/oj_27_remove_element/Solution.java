package oj_solution.oj_27_remove_element;

public class Solution {
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
}
