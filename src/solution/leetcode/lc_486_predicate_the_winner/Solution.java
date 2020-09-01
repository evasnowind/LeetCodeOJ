package solution.leetcode.lc_486_predicate_the_winner;

/**
 * @author chenglong.yu
 * created on 2020/9/1
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        /*
        定义二维数组 dp，其行数和列数都等于数组的长度，dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值，注意当前玩家不一定是先手。

只有当 i≤j 时，数组剩下的部分才有意义，因此当 i>j时，dp[i][j]=0

当 i=j 时，只剩一个数字，当前玩家只能拿取这个数字，因此对于所有 0≤i<nums.length，都有dp[i][i]=nums[i]。

当 i<j时，当前玩家可以选择 \textit{nums}[i]nums[i] 或 \textit{nums}[j]nums[j]，然后轮到另一个玩家在数组剩下的部分选取数字。在两种方案中，当前玩家会选择最优的方案，使得自己的分数最大化。因此可以得到如下状态转移方程：

dp[i][j]=max(nums[i]−dp[i+1][j],nums[j]−dp[i][j−1])

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
         */

        int length = nums.length;
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            //dp递推公式的基础
            dp[i][i] = nums[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }


    /**
     * 同样定义递归helper函数的返回值为当前做选择的玩家能赢过对手的分数，如果大于零，则表示当前玩家，在这个子问题中赢了。
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner2(int[] nums) {
        /*
        可以看出实际上这个上面的非递归解法不过是将递归中由函数栈的操作过程，利用数组、循环自己实现了。
         */
        return helperForPredictTheWinner2(nums, 0, nums.length - 1) >= 0;
    }

    private int helperForPredictTheWinner2(int[] nums, int i, int j) {
        if (i == j) {
            /*
            递归结束条件：表示当前只有1个数字，只能拿掉这个数，拿走后就比对手多了nums[i]
             */
            return nums[i];
        }

        int leftRes = nums[i] - helperForPredictTheWinner2(nums, i + 1, j);
        int rightRes = nums[j] - helperForPredictTheWinner2(nums, i, j-1);
        return Math.max(leftRes, rightRes);
    }


    public boolean PredictTheWinner3(int[] nums) {
        /*
        对采用二维数组进行DP的解法进一步优化：很常规的思路，二维数组实际上并不需要。
        我们只关心上一步的计算结果。

           dp[i][j]=max(nums[i]−dp[i+1][j],nums[j]−dp[i][j−1])
           因此用一个数组记录，简化空间消耗
         */
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j-1]);
            }
        }
        return dp[length-1] >= 0;
    }

}
