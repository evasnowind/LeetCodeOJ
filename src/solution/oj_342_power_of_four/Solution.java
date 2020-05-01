package solution.oj_342_power_of_four;

public class Solution {
	/*
	 * 分析：若是用循环或是递归，时间复杂度应该是O(logn)
	 * 		从二进制考虑，4的幂肯定也是2的幂，但根据4的幂的特点
	 * 		1			1
	 * 		4		  100
	 * 		16		10000
	 * 		64	  1000000
	 * 		可以得出4的幂中1必然出现在奇数位置，因此用0x55555555进行
	 * 		与运算，排除那些是2的幂、不是4的幂的数，例如32（100000，
	 * 		2的5次方，但01010101与之后等于0，排除掉）
	 */
	public boolean isPowerOfFour(int num) {
        return ((num&(num-1)) == 0) && ((num & 0x55555555) != 0);
    }
}
