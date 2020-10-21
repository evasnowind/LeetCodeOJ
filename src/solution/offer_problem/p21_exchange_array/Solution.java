package solution.offer_problem.p21_exchange_array;

public class Solution {
    /**
     * 与leetcode 283 类似
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }
        return nums;
    }
}
