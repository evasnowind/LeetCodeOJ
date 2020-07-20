package solution.lc_287_find_duplicate_number;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/5/26
 */
public class Solution {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return nums[i];
            }
        }

        return 0;
    }
}
