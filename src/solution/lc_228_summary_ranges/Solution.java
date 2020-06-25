package solution.oj_228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/*
	 * 分析：思路简单，直接遍历即可，整个时间复杂度为O(N)（采用聚集分析法分析即可得）
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(null == nums) return res;
		for(int i = 0; i < nums.length; i++){
			int start = i; 
			while((i+1) < nums.length && nums[i+1] - nums[i] == 1){
				i++;
			}
			if(i > start) {
				res.add(nums[start] + "->" + nums[i]);
			} else{
				res.add(nums[i]+"");
			}
		}
        return res;
    }
	
	public static void main(String[] args){
		int[] test = new int[]{0,1,2,4,5,7};
		List<String> res = summaryRanges(test);
	}
}
