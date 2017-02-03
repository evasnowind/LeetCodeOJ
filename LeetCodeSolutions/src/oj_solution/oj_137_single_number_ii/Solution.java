package oj_solution.oj_137_single_number_ii;

public class Solution {
	/*
	 * 思路：本题与single number i不一样，不是很直观，下面代码思路来自
	 * http://blog.csdn.net/jiadebin890724/article/details/23306837
	 * 统计每个数字相同位置的二进制位，由于除了一个数以外，所有数都是3个
	 * 相同数字，那么每一二进制上1或是0的个数必然是3N或是3N+1
	 * 3N+1的情况记录下这个1的位置，不断重复即可得到单独的一个数
	 * 
	 * 参考资料：
	 * http://blog.csdn.net/jiadebin890724/article/details/23306837
	 * https://discuss.leetcode.com/topic/2031/challenge-me-thx/2
	 * https://discuss.leetcode.com/topic/11877/detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
	 * 
	 */
	public int singleNumber(int[] nums) {
        int res = 0;
		for(int i = 0; i < 32; i++){
			int cnt = 0;
			int mask = 1 << i;
			for(int j = 0; j < nums.length; j++){
				if((nums[j] & mask) != 0){
					/*
					 * 注意：这里必须是!=0，因为输入可能是正可能是负，导致这里进行与操作后得到的
					 * 不一定是正数，例如：2&2=2>0,但-2&2<0
					 */
					cnt += 1;
				}
			}
			if(cnt % 3 == 1){
				res = res | mask;
			}
		}
        return res;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = new int[]{2,2,3,2};//[-2,-2,1,1,-3,1,-3,-3,-4,-2]
		int res = s.singleNumber(nums);
		System.out.println(res);
	}
}
