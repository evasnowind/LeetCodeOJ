package solution.offer_problem.p57_i_two_sum;

/**
 * @author chenglong.yu
 * created on 2020/11/18
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int i = 0, j = nums.length - 1;
        /*
        两个指针向中间夹逼
         */
        while(i < j) {
            sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                break;
            }
        }
        if (i >= j) {
            return null;
        }

        return new int[]{nums[i], nums[j]};
    }
}
