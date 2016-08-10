package oj_solution.oj_189_rotate_array;

public class Solution {
	/*
	 * 注意：k若大于nums的个数，需要先取余，即k = k % nums.length
	 * 
	 * 下面针对 https://discuss.leetcode.com/topic/9801/summary-of-c-solutions 给出的各种
	 * solution进行简要的思路分析：
	 *  
	 * 思路1：将倒数k个元素拷贝一份，然后将nums中的剩余元素
	 *		全部后移，再将k个元素拷到前k个位置
	 * 思路2：模拟循环操作，循环k次，每次只挪动1位数，即可只用O(1)的空间，但数组较大时会超时，效率较低，不可接受。
	 * 		进一步改进时：对于每个数字，挪动1次，直接挪动k个位置，第k个位置的数暂时保存，留作
	 * 		下一次即将挪动的数，如此循环n次，即可得到结果。
	 * 		——利用了循环移位中，从哪个位置出发，加上m*k（m>=0）之后，必然会回到这个位置的特性作为结束条件
	 * 
	 * 思路3：先逆序整个数组，再分别逆序前k个、后n-k个，即可得。
	 * 
	 * 思路4：#4我没有仔细分析，但应该和#5思路一致
	 * 
	 * 思路5：n-k>=k时，先与后面[n - k,...,n - 1]这k个元素交换，保证[n - k,...,n - 1]是结果顺序，
	 * 		之后再用同样的步骤操作[0,...,n-k-1]，不断交换，保证最后结果
	 * 
	 */
	public void rotate(int[] nums, int k) {
        if(null == nums || k <= 0) return;
        if(k >= nums.length) k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
	
	private void reverse(int[] nums, int start, int end) {
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start +=1;
			end -= 1;
		}
	}
}
