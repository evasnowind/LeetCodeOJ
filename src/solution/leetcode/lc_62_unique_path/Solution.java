package solution.leetcode.lc_62_unique_path;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/9/17
 */
public class Solution {

    /**
     * 杨辉三角：
     * 排列组合，直接算出来
     * Cm-1, m+n-2
     *
     * 动态规划思路：
     * dp[i][j] 到达[i,j]最多的路径
     * 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
