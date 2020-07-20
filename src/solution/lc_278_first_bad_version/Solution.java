package solution.lc_278_first_bad_version;

public class Solution{
	/*
	 * 由于需要有一个父类集成，用于提供isBadVersion这个接口，此处直接注释该方法，测试直接在
	 * leetcode官网上做的
	 * 
	 * 思路：思路很简单，有序的数组，找某个特定的数字，很容易联想到用二分查找
	 */
	/*
	public int firstBadVersion(int n) {
		int low = 1, high = n;
		while(low < high){
			int mid = low + (high - low) / 2;
			if(!isBadVersion(mid)){
				low = mid + 1; 
			} else {
				high = mid;
			}
		}
		return low;
    }
	*/
}
