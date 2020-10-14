package solution.offer_problem.p03_find_repeat_number;

/**
 * @author chenglong.yu
 * created on 2020/10/14
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                while(i != nums[i]) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    int tmp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return -1;
    }
}
