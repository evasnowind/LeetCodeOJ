package solution.offer_problem.p45_get_min_num_by_num_array;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/10/8
 */
public class Solution {
    public String minNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "";
        }

        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, (x,y) ->(x+y).compareTo((y+x)));
        StringBuilder builder = new StringBuilder();
        for (String str : numStr) {
            builder.append(str);
        }
        return builder.toString();
    }
}
