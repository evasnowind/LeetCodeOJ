package solution.leetcode.lc_1423_max_points_you_can_obtain_from_cards;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2021/2/15
 */
public class Solution {

    /**
     * 此题看过题解后有种恍然的感觉。
     * 如果直接暴力求解、那得遍历n多可能性，左边拿m、右边拿k-m个这样，得比较所有可能性，铁定会超时。
     * 那换种思路。就最终结果而言，肯定是左边拿m、右边拿k-m个，并且题目也没要求算出左边拿几个、右边拿几个，
     * 那我们先计算所有和、然后求出中间没有被拿走的那部分和，
     * 并要求中间那部分最小，则左右两边拿到的必然是最大值。
     * 而求中间最小的过程，可以用滑动窗口。
     * 个人理解：此处可以看到，使用滑动窗口思想时，主要特征就是：连续子数组、求最值
     *
     *
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        int sum = 0;
        for(int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for(int i = windowSize; i < n; i++) {
            sum = sum + cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
