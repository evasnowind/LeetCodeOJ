package solution.lc_96_unique_bst;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/7/15
 */
public class Solution {

    /**
     * 解析参见 https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i; j++) {
                memo[i] += memo[i-1] * memo[i - j];
            }
        }
        return memo[n];
    }

}
