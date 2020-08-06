package solution.leetcode.lc_275_h_index_ii;

public class Solution {
	/**
	 * 分析：输入已经排好序，很容易让人想到需要用到
	 * 		二分查找的思想
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		if(null == citations || citations.length == 0) return 0;
		int len = citations.length, left = 0, right = len - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(citations[mid] == len - mid){
				return len - mid;
			} else if(citations[mid] > len - mid){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return len - left;
    }
}
