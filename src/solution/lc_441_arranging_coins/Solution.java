package solution.lc_441_arranging_coins;

public class Solution {
	/*
	 * 分析：简单题目，明显与等差数列有关，如果比较暴力的计算，可以从n/2开始，
	 * 	利用等差数列和公式(1+m)*m/2来计算，然后逐渐逼近。而
	 * 		逐渐逼近的过程可以用类似二分算法中的逻辑，因此有如下代码。
	 * 注意：除以2用*0.5来代替，一方面是为了避免溢出，另一方面也是数字类型
	 * 		强制转换的需要，转成double避免损失精度
	 * 另一种思路：直接利用(1+m)*m/2=n，利用一元二次方程直接解出，注意计算时
	 * 数字类型的强制转换
	 * 上面两种思路参考：https://discuss.leetcode.com/topic/65593/java-clean-code-with-explanations-and-running-time-2-solutions
	 * 
	 * 我想到的思路:从m=sqrt(n)处开始，利用(1+m)*m/2计算，每次步长是1逼近n，但
	 * 时间复杂度肯定要比上面的差，n比较大时很可能超时
	 * 
	 * 注意：需要用到逐次逼近的时候，应该想到是否可以应用二分查找的思想！！
	 */
	public int arrangeCoins(int n) {
		int start = 0, end = n, mid = 0;
		while(start <= end){
			mid = (start + end) >>> 1;
			if((0.5 * mid * mid + 0.5 * mid) <= n){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
    }
}
