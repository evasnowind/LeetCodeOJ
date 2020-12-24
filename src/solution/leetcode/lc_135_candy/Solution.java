package solution.leetcode.lc_135_candy;

/**
 * @author chenglong.yu
 * created on 2020/12/24
 */
public class Solution {

    /**
     * [1,0,2]
     * 题目要求相邻元素，也就意味着需要同时满足：
     * - 从左往右看：i=0, i++，比较i与i-1，比较的是当前元素左边
     * - 从右往左看：i=n-1, i--，比较i与i+1，比较的是当前元素右边，若当前元素更大加1
     *
     * 两条同时满足，才保证是相邻。并且这两者最大值。举例来讲：
     * [1,0,2]
     * 从左往右看：每个元素应分配情况[1,1,2]
     * 从右往左看：每个元素应分配情况[2,1,1]
     * 只有取每个位置左、右比较的最大值，才能保证正确的结果。
     *
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];

        left[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 1, result = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < (len - 1) && ratings[i] > ratings[i+1]) {
                right++;
            } else {
                right = 1;
            }

            result += Math.max(left[i], right);
        }
        return result;
    }
}
