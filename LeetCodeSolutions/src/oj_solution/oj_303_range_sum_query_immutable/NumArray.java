package oj_solution.oj_303_range_sum_query_immutable;

//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);
public class NumArray {
	/*
	 * 分析：我最开始的想法是额外用一个矩阵保存已经算好的结果，每次去查，
	 * 		但发现有更好的思路，参见https://discuss.leetcode.com/topic/29194/java-simple-o-n-init-and-o-1-query-solution
	 * 
	 * 基本思路是对的，即根据题目里说“数据不会变、会查询多次”，想出用一个表来
	 * 保存已经算过的结果，但题目中immutable实际指的是nums本身不会变，可以直接
	 * 用nums来保存计算结果
	 */
	
	int[] numsRef;
	public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++){
        	nums[i] += nums[i-1];
        }
        numsRef = nums;
    }

    public int sumRange(int i, int j) {
    	if(0 == i) return numsRef[j];
        return numsRef[j] - numsRef[i-1];
    }
}
