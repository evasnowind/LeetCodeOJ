package solution.oj_69_sqrt;

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
}
