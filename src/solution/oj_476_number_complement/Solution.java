package solution.oj_476_number_complement;

public class Solution {
	/**
	 * 分析：比较直观的思路是通过循环，算出num每一位是1还是0，进而得到每一位
	 * 		的补数，然后将每一位补数拼一起即可。但这样略麻烦。下面的算法来自
	 * 		https://discuss.leetcode.com/topic/74642/java-1-line-bit-manipulation-solution
	 * 		算法本质上利用了二进制数的特点：
	 * 			a.(Integer.highestOneBit(n) << 1) - 1 可以获取n的掩码（这个思路很有用！想想IP和子网掩码）
	 * 			b.n取反之后，用掩码按位与，即可得到结果
	 * 
	 * 补充：有关位运算的题目，目前可以看到经常涉及到移位运算，或是利用原码/反码/补码的关系，
	 * 		异或运算，以及按位与/按位或运算，来计算出最终的结果。
	 * 		例如，经典题目“计算一个int数的二进制表示中包含有多少个1”，算法实现参考
	 * 		http://15838341661-139-com.iteye.com/blog/1642525
	 * 		常规思路是通过移位运算遍历每一位，按位与判断每一位是否为1，时间复杂度O(log2 v)
	 * 		而经典实现如下：
	 * 
		public int bitCount4( int x )  
		{  
		   int count = 0;  
		   while ( x != 0 )  
		   {  
		     x &= x - 1;  
		     count++;  
		   }  
		   return count;  
		}
	 * 	这种算法利用了 x & (x-1) 可以消去 x 二进制数的最后一位 1这一点，x中有多少个1，就会循环多少次.
	 * 	而通过阅读Integer源码中有关位运算的那些方法的实现，可以看出
	 * 		移位运算，
	 * 		利用原码/反码/补码的关系
	 * 		按位与/按位或运算
	 * 		异或运算
	 * 	的重要性
	 * 
	 * 异或运算经典题目：找出仅有一个数出现一次、其他出现两次的数组中只出现一次的数
	 * 		
	 * @param num
	 * @return
	 */
	public int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
