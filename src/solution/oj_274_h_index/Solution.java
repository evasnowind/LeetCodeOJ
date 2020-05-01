package solution.oj_274_h_index;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	/**
	 * 主要是理清概念，什么是h index即可。
	 * 很明显，排序后计算更加方便。
	 * 
	 * discuss上提供了一种更简单的思路，时间为O(N)，用空间换时间，参见
	 * https://discuss.leetcode.com/topic/23307/my-o-n-time-solution-use-java
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		if(null == citations || citations.length == 0) return 0;
		int len = citations.length;
		Arrays.sort(citations);
		for(int i = 0; i < len; i++){
			if(citations[i] >= len - i){
				return len - i;
			}
		}
        return 0;
    }
}
