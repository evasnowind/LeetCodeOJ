package oj_solution.oj_414_third_max_number;

public class Solution {

	/**
	 * 分析：下面代码取自 https://discuss.leetcode.com/topic/63715/java-neat-and-easy-understand-solution-o-n-time-o-1-space
	 * 		其实这种思路最简单，也最直观，即遍历整个数组，考虑未满3个数、满3个数的情况。满3个数，则不断腾挪，
	 * 		保证只保存最大的3个数；未满3个，则找到最大即可
	 * 		
	 * 	另外的思路：
	 * 	用优先级队列	https://discuss.leetcode.com/topic/63086/java-priorityqueue-o-n-o-1
	 * @param nums
	 * @return
	 */
	public int thirdMax(int[] nums) {
		Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
