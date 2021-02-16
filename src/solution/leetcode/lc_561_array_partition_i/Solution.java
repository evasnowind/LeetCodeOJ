package solution.leetcode.lc_561_array_partition_i;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2021/2/16
 */
public class Solution {
    /**
     * 这是一道观察、总结规律的题目
     *
     * 官方题解给出了数学证明，
     * https://leetcode-cn.com/problems/array-partition-i/solution/shu-zu-chai-fen-i-by-leetcode-solution-9m9y/
     * 不想看。。。。
     *
     * 但我们自己观察一下例子，可以看到
     * “小数字组成一对、大数字组成一对，每对取 min之后，求和得到的结果才是最大的。”
     * 比如题目示例：nums = [1,4,3,2]
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     *
     * 那么我们从直观例子上感受下，如果一大一小两个数字取min，则大数字会被拉低，
     * 导致最后整体和较低。如果将较小的数字拼在一起，而较大的数字放在一起，
     * 那么小数字就无法拉低大数字的贡献，最终值会比较大。
     * ——算是贪心的思想吧。
     *
     * 所以只需要排序，然后相邻数组排成一组即可。
     *
     *
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += Math.min(nums[i], nums[i+1]);
            i++;
        }
        return sum;
    }
}
