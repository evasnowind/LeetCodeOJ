package solution.leetcode.lc_279_perfect_squares;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenglong.yu
 * created on 2020/10/5
 */
public class Solution {
    public int numSquares(int n) {
        return numSquaresHelper(n, new HashMap<>());
    }

    private int numSquaresHelper(int k, HashMap<Integer, Integer> memo) {
        Integer res = memo.get(k);
        if (null != res) {
            return res;
        }

        if (0 == k) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= k; i++) {
            count = Math.min(count, numSquaresHelper(k - i * i, memo) + 1);
        }
        memo.put(k, count);
        return count;
    }

    public int numSquaresByDP(int n) {
        int[] dp = new int[n + 1];
        //DP过程实际上就是利用一个数组来保存之前的计算结果
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        /*
        先初始化一个平方数组squareNums，显然，对于完全平方数，我们最大值只需要到Math.sqrt(n) + 1大小的数组,
        因为若大于Math.sqrt(n)，则可能超过n，这是没有意义的。
         */
        int maxSquareIndex = (int)Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (squareNums[j] > i) {
                    /*
                    当前要寻找i对应的完全平方数个数，如果squareNums[j] > i，
                    意味着不可能在squareNums第j以及之后的元素，使其平方和 <= i，
                    直接剪枝即可
                     */
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNums[j]] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 13;
        int res = s.numSquares(n);
        System.out.println(res);

        res = s.numSquaresByDP(n);
        System.out.println(res);
    }
}
