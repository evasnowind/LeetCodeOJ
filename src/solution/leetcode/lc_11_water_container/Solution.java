package solution.leetcode.lc_11_water_container;

public class Solution {
	/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
	 * 
	 * 参考：https://discuss.leetcode.com/topic/16754/simple-and-fast-c-c-with-explanation
	 * 
	 * 一般思路：实际要算的是max(min(ai,aj)*|i-j|)遍历所有可能，双重循环
	 * 优化：还是需要根据输入数据特点，先考虑x方向最大的,即i=0 j=height.length-1的情况
	 * 后续想要比这个容积更大，只能是高度更高，因此跳过那些x方向已经小于xmax并且高度也不高的
	 * 数据
	 */



	public static void main(String[] args) {
		int[] arr = new int[]{1,8,6,2,5,4,8,3,7};

		Solution s = new Solution();
		int res = s.maxArea(arr);
		System.out.println(res);
	}

	public int maxArea(int[] height) {
		if(null == height || height.length == 0) return 0;
		int water = 0;
		int i = 0;
		int j = height.length - 1;
		while(i < j){
			int h = Math.min(height[i], height[j]);
			water = Math.max(water, h * (j-i));
			while(height[i] <= h && i < j) i++;
			while(height[j] <= h && i < j) j--;
		}
		return water;
    }
}