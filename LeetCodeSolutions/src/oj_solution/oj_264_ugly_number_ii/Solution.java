package oj_solution.oj_264_ugly_number_ii;

public class Solution {
	/*
	 * 参考：https://discuss.leetcode.com/topic/21882/my-16ms-c-dp-solution-with-short-explanation
	 * 思路解析：最直白的思路是从1数到n、算一下每个数是不是丑数、是的计数。但效率太低。根据丑数的定义，
	 * 很容易能推导出，任何大于1的丑数，都是由其他更小的丑数乘以2/3/5之后得到的，因此更优化的思路是从1开始，
	 * 直接算出下一个丑数，关键就是如何保存已有的丑数、如何利用数组中的丑数计算下一个丑数。
	 * 
	 * 保存：用一个数组uglyNums从小到大保存，第一个是1，后续挨个算
	 * 计算：uglyNums数组中，新的丑数必然是数组中已有丑数乘以2/3/5之后，最小的那个。
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
