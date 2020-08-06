package solution.leetcode.lc_343_integer_break;

/**
 * @author chenglong.yu
 * created on 2020/7/30
 */
public class Solution {

    public int integerBreak(int n) {
        //数组默认值已经将0/1的情况覆盖，不用提前判断。
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.integerBreak(10);
    }
}
