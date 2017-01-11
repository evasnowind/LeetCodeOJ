package oj_solution.oj_476_number_complement;

public class Solution {
	/**
	 * 分析：比较直观的思路是通过循环，算出num每一位是1还是0，进而得到每一位
	 * 		的补数，然后将每一位补数拼一起即可。但这样略麻烦。下面的算法来自
	 * 		https://discuss.leetcode.com/topic/74642/java-1-line-bit-manipulation-solution
	 * 		算法本质上利用了二进制数的特点：
	 * 			a.(Integer.highestOneBit(n) << 1) - 1 可以获取n的掩码（这个思路很有用！想想IP和子网掩码）
	 * 			b.n取反之后，用掩码按位与，即可得到结果
	 * @param num
	 * @return
	 */
	public int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
