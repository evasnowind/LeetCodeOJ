package solution.leetcode.lc_503_next_greater_number_ii;

import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/10/29
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();

        /*
        思想上跟next greater number 一样，但由于要考虑循环，一种思路是
        将数组复制一遍，比如
        [2,1,2,4,3]变成[2,1,2,4,3,2,1,2,4,3]
        但可以利用取模，变相达到这个效果。
         */
        for (int i = len * 2 - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}
