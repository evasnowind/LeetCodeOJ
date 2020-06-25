package solution.oj_338_count_bits;

public class Solution {
	/*
	 * 常规思路：循环num次，每次判断当前数的二进制表示有多少个1（比如通过移位操作，每次
	 * 			判断末尾），此方法即题目中所说的O(n*sizeof(integer))的方法
	 * 优化思路：找规律，根据hint，有两种思路，我想到的是一种，即根据奇偶性，写几个数后
	 * 			可以发现第i数的1的个数为： 
	 * 				f[i] = f[i / 2] + i % 2 （或者是i&1，效率更高）
	 * 			原因在于： 第i个数是由第i/2个数左移移一位获得，但左移后最后一位还需要单独
	 * 			判断是否有1，即判断奇偶性
	 * 
	 * 			另一种思路，也是hint给出的，discuss上有提到，即根据不同区间来判断，每个
	 * 			区间都是二进制位数相同，每当是2的乘方时，只是在最前面加个1，后面的变化与
	 * 			之前的区间变化一致，具体算法参见
	 * 			  https://discuss.leetcode.com/topic/41785/simple-java-o-n-solution-using-two-pointers
	 * 
	 * 拓展：各种计算数字中1个数的算法参见 http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
	 * 
	 * 注意！！：涉及位运算时，注意结合性与优先级，例如下面代码，如果i&1没加括号，实际是先算res[i/2] + i
	 */
	public int[] countBits(int num) {
		if(num < 0) return new int[1];
		int[] res = new int[num+1];
		res[0] = 0;
		for(int i = 1; i <= num; i++){
			res[i] = res[i/2] + (i & 1);
		}
		return res;
    }
}
