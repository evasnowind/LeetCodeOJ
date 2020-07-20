package solution.lc_405_convert_a_number_to_hex;

public class Solution {
	/*
	 * 分析：数制转换的方法无非就是/n %n，不断重复这个操作，我这里想错的一点是负数得特殊处理，
	 * 然而没必要，因为我们的最终目标是将num这个十进制数的二进制表示转为十六进制，没必要用
	 * num/16 num%16这样计算，我们直接从二进制转到十六进制就可以了，因此有了如下算法，参考
	 * https://discuss.leetcode.com/topic/65028/java-clean-code-with-explanations-and-running-time-2-solutions
	 * 二进制的情况下，不需要考虑正负，只需要考虑将每4位转为一个十六进制数即可 
	 */
	public String toHex(int num) {
		char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		if(0 == num) return String.valueOf(0);
		StringBuilder builder = new StringBuilder();
		while(0 != num){
			builder.insert(0, map[num & 0b1111]);
            num = num >>> 4;
		}
		return builder.toString();
    }
}
