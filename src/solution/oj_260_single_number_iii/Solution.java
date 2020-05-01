package solution.oj_260_single_number_iii;

public class Solution {
	/*
	 * 具体分析参考https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
	 * 其本质还是和https://leetcode.com/problems/single-number/思路一致，
	 * 利用XOR计算特性，找出不同的数。此处有2个数据不同，第一次XOR遍历时得出的
	 * 结果是这两个数XOR的结果，那么这个结果表明了这两个数二进制位的差异，那么直接
	 * 根据此结果，挑选某个值为1的二进制位（这个位置上两个数分别是0 1，记作第i位），进行第二次XOR遍历，
	 * 第i位是0的数进行XOR，不是0的进行XOR。相同的数据必然会落在同一个分支内进行操作，
	 * 不同的只有我们要找的那两个数，分别落在不同分支中，最后即可求得
	 * 
	 * PS 下面算法中，采用右往左数第一个不是0的数作为第i位，为了计算这个值，采用了
	 * 		diff &= -diff;
	 * 这种做法，非常elegant! 首先，int值在计算机中都是补码表示，即反码+1
	 * 		例如，一开始的diff = 6，二进制 0......110 （第一个符号位）,-6是（1111...010）
	 * 		两者进行&操作，即可获得我们想要的仅有一个位是1的结果
	 * 
	 */
	
	public int[] singleNumber(int[] nums) {
		int[] res = new int[2];
		if(null == nums || nums.length == 0) return res;
		int diff = 0;
		for(int num:nums){
			diff ^= num;
		}
		
		diff &= -diff;
		for(int num:nums){
			if((diff & num) == 0){
				res[0] ^= num;
			} else{
				res[1] ^= num;
			}
		}
		return res;
    }
	
	/*
	public static void main(String[] args){
		int[] test = new int[]{1, 2, 1, 3, 2, 5};
		int[] res = singleNumber(test);
	}
	*/
}
