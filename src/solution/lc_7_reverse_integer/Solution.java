package solution.oj_7_reverse_integer;

public class Solution {
	/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
	 */
	public int reverse(int x) {
		int result = 0;
		int sign = x>0? 1:-1;
		int tmp = Math.abs(x);

        while(tmp != 0){
        	int rtmp = (Integer.MAX_VALUE - tmp % 10)/10;
        	if(rtmp < result) {
        		return 0;
        	}
        	result = result*10 + tmp % 10;
        	tmp = tmp / 10;
        };
        
        return sign * result;
    }


    /*
    为了便于解释，我们假设 \text{rev}rev 是正数。

如果 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥
10
INTMAX
​
 。
如果 \text{rev} > \frac{INTMAX}{10}rev>
10
INTMAX
​
 ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
如果 \text{rev} == \frac{INTMAX}{10}rev==
10
INTMAX
​
 ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。

作者：LeetCode
链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int reverse2(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
			if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int x = -11;
		System.out.println(x % 10);
		System.out.println(x / 10);
		System.out.println(s.reverse2(x));
		System.out.println(s.reverse2(-122));
		System.out.println(s.reverse2(234));
	}
}
 