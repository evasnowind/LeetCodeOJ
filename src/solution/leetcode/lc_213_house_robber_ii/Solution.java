package solution.leetcode.lc_213_house_robber_ii;

/**
 * @author chenglong.yu
 * created on 2021/4/15
 */
public class Solution {

    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
        }

    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start+1]);
        for(int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
