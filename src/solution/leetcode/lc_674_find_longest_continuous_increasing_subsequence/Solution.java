package solution.leetcode.lc_674_find_longest_continuous_increasing_subsequence;

/**
 * @author chenglong.yu
 * created on 2021/1/24
 */
public class Solution {

    /**
     * 简单题目。
     * 只需要一次遍历，每次与上一个数判断是否存在持续递增关系即可。
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int lastNum = nums[0];
        int curLen = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > lastNum) {
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = 1;
            }
            lastNum = nums[i];
        }

        return maxLen;
    }
}
