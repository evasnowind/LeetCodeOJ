package solution.lc_1014_best_sightseeing_pair;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/6/17
 */
public class Solution {

    /**
     * 先打卡再学习
     * https://leetcode-cn.com/problems/best-sightseeing-pair/solution/zui-jia-guan-guang-zu-he-by-leetcode-solution/
     * @param
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }

}
