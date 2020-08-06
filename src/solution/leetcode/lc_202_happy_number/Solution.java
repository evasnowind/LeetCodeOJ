package solution.leetcode.lc_202_happy_number;

public class Solution {
	/*
	public boolean isHappy(int n) {
	    Set<Integer> inLoop = new HashSet<Integer>();
	    int squareSum,remain;
		while (inLoop.add(n)) {
			squareSum = 0;
			while (n > 0) {
			    remain = n%10;
				squareSum += remain*remain;
				n /= 10;
			}
			if (squareSum == 1)
				return true;
			else
				n = squareSum;

		}
		return false;

	}
	*/
	/*
	 * 本题关键是要用实际例子演算一遍，发现如果不是happy number，
	 * 那么整个无限演算过程中会出现重复数字，那么简单思路是用一个
	 * set记录所有运算过程中的数，遇到重复或是1则结束，如上面的程序
	 * (出处：https://discuss.leetcode.com/topic/25026/beat-90-fast-easy-understand-java-solution-with-brief-explanation)
	 * 
	 * 更精妙的思路：实际要判断的核心是能否演算1、或是找到重复数字，而将整个演算过程看做
	 * 一个闭环，则可以采用龟兔赛跑算法找出重复点
	 * 参考：
	 * （1）http://blog.csdn.net/zju_sutton/article/details/8850346
	 * （2）https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
	 * （3）https://en.wikipedia.org/wiki/Cycle_detection
	 * 	
	 * 
	 */
	public boolean isHappy(int n) {
		int slow, fast;
		slow = fast = n;
		do{
			slow = getDigitSquareNum(slow);
			fast = getDigitSquareNum(fast);
			fast = getDigitSquareNum(fast);
		} while(slow != fast);
		if(slow == 1) return true;
		return false;
    }
	
	private int getDigitSquareNum(int n){
		int sum = 0;
		int tmp;
		while(n != 0){
			tmp = n % 10;
			sum += tmp * tmp;
			n = n / 10;
		}
		return sum;
	}
}
