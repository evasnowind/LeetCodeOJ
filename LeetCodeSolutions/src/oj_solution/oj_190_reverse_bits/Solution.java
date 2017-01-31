package oj_solution.oj_190_reverse_bits;

public class Solution {
	/*
	 * 分析：注意仔细读题，弄明白意思，位的逆转操作与int数不一样，int数逆转
	 * 		操作次数等于int数所含的数字个数，位逆转则需要将整个int数里的所有
	 * 		位都逆序，一般int都是32位，因此必须转换32次。
	 * 注意：java中位右移运算要区分>> 和 >>>，>>带符号位，开头是1则填充1，否则填充0；
	 * 		>>>不带符号位，总是填充0
	 * 优化：若多次调用，常用思路就是用空间换时间，那么就可以做一个映射表，32位不
	 * 		常见，但8位重复利用次数较多，可以用如下思路
	 * 			I 生成一个HashMap<Byte, Integer> 第一次算时直接生成byte值为0~255的数逆序
	 * 			  后所得的结果，保存到映射表，后续直接查即可。
	 * 			II 与I类似，生成一个HashMap<Byte, Integer>，计算时先查表，有则直接返回，
	 * 			   没有则算并填表
	 * 实现参考：https://discuss.leetcode.com/topic/9764/java-solution-and-optimization/2
	 * 另一种思路：https://discuss.leetcode.com/topic/9811/o-1-bit-operation-c-solution-8ms
	 * 
	 * 其他类似题目参考：算法-求二进制数中1的个数 http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html
	 */			 
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int res = 0;
    	for(int i = 0; i < 32; i++){
    		res = res << 1;
    		res |= n & 1;
    		n = n >>> 1;
    	}
    	return res;
    }
}
