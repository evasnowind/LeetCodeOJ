package oj_solution.oj_264_ugly_number_ii;

public class Solution {
	/*
	 * 参考：https://discuss.leetcode.com/topic/21882/my-16ms-c-dp-solution-with-short-explanation
	 */
	public int nthUglyNumber(int n) {
		int idx2 = 0, idx3 = 0, idx5 = 0;
		int [] uglyNums = new int[n];
		uglyNums[0] = 1;
		for(int i = 1; i < n; i++){
			uglyNums[i] = Math.min(Math.min(uglyNums[idx2] * 2, uglyNums[idx3] * 3), uglyNums[idx5] * 5);
			if(uglyNums[i] == uglyNums[idx2] * 2) idx2 += 1;
			if(uglyNums[i] == uglyNums[idx3] * 3) idx3 += 1;
			if(uglyNums[i] == uglyNums[idx5] * 5) idx5 += 1;
		}
        return uglyNums[n-1];
    }
}
