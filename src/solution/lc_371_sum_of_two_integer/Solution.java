package solution.oj_371_sum_of_two_integer;

public class Solution {
	/*
	 * 分析：不让用=/-运算符做加减法，直观上很容易想到用位运算，接下来
	 * 就是怎么进行位运算，具体思路参考如下帖子：
	 * https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
	 * 而下面这个帖子中更是总结了一些有关位运算的trick，推荐大家都看看
	 * https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently/2
	 */
	public int getSum(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		
        while(b != 0){
        	/*
        	 * 这一步算出了二进制加法中a和b相同位置都是1的情况，即所有的进位，
        	 * 进位算出后，carry左移一位就是进位加到对应位置
        	 */
        	int carry = a & b;
        	/*
        	 * a^b计算了a和b中相同位置数字不相同，即一个是1、另一个是0的情况，
        	 * 两个都是1的情况已通过上面a&b算出，两个是0的情况对加法没有影响，
        	 * 也不用考虑。
        	 */
        	a = a ^ b;
        	b = carry << 1;
        }
        /*
         * 在carry=0时说明已经没有进位，a ^ b已经是最终的结果
         */
        return a;
    }
	
	public int getSubtract(int a, int b){
		while(b != 0){
			/*
			 * (~a) & b 算出那些满足如下条件的二进制位：b上有1、但a上没有1的、
			 * 需要向高位借位
			 */
			int borrow = (~a) & b;
			/*
			 * 算出借位后，把a和b中二进制数字中同位且数字相同的直接减掉，
			 * 获得数字不同的二进制数（记作m），这个数再减去借位即为结果。显然，
			 * 这种情况应该用^
			 */
			a = a ^ b;
			/*
			 * 借位要左移一位才是m真正要减去的数
			 */
			b = borrow << 1;
		}
		return a;
	}
	
	// Recursive
	public int getSumRecursive(int a, int b) {
		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
	}

	// Recursive
	public int getSubtractRecursive(int a, int b) {
		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
	}

	// Get negative number
	public int negate(int x) {
		return ~x + 1;
	}
	
}
