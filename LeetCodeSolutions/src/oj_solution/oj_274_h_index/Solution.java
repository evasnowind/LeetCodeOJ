package oj_solution.oj_274_h_index;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	/**
	 * 主要是理清概念，什么是h index即可。
	 * 很明显，排序后计算更加方便。
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
