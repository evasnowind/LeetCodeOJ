package solution.leetcode.lc_628_max_product_of_three_numbers;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2021/1/20
 */
public class Solution {

    /**
     * 1、暴力求解，3个循环
     * ——想想也知道时间都到O(n^3)了，肯定不是lc想要的解法
     * 2、找规律
     * 2.1 如果都是正数，则只需要找到最大的3个数、求乘积；
     * 2.2 如果都是负数，则只需要找到最大的3个数、求乘积；
     * 2。3 如果有正、有负数，则最大的值可能是：
     * （1）3个最大正数的乘积
     * （2）2个最小负数与最大正数的乘积
     *
     * 综上，整合到一起，即得结果。
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1],
                nums[len - 3] * nums[len - 2] * nums[len - 1]);
    }
}
