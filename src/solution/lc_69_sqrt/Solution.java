package solution.lc_69_sqrt;

import java.math.BigDecimal;

public class Solution {
	/*
	 * 这种逐次逼近的题目，应该去想二分法，然后注意溢出问题
	 * 
	 * 本题中2个地方考虑到溢出（加法溢出、乘法溢出）
	 */
	public int mySqrt(int x) {
		if(0 == x)
			return 0;
		int low = 1, high = x, result = 0;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(mid <= x / mid){
				low = mid + 1;
				result = mid;
			} else {
				high = mid - 1;
			}
		}
		return result;
    }

    public int mySqrt2(int x) {
		if (0 == x) {
			return 0;
		}

		long left = 1;
		long right = x / 2 + 1;
		while(left < right) {
			//取右中位数，否则可能出现无限循环的情况
			long mid = (right + left + 1) / 2;
			long square = mid * mid;
			if (square > x) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return (int)left;
	}

    public int mySqrt0(int x) {
		if (0 == x) {
			return 0;
		}

		int halfOfX = x / 2 + 1;
		int result = 0;
		BigDecimal tmpDecimal;
		BigDecimal xDecimal = new BigDecimal(x);
		for (int i = 1; i <= halfOfX; i++) {
			BigDecimal a = new BigDecimal(String.valueOf(i));
			tmpDecimal = a.multiply(a);
			if (tmpDecimal.compareTo(xDecimal) == 0) {
				return i;
			} else if (tmpDecimal.compareTo(xDecimal) > 0) {
				result = i - 1;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int a = 4;
		System.out.println("a=" + a + " sqrt=" + s.mySqrt0(a));
//
//		a = 5;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 6;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 7;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 8;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 9;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 10;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 11;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 12;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 13;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 14;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 15;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));
//		a = 16;
//		System.out.println("a=" + a + " sqrt=" + s.mySqrt1(a));

		a = Integer.MAX_VALUE;
		System.out.println("a=" + a + " sqrt=" + s.mySqrt0(a));
	}
}
