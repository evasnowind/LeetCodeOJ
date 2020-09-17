package solution.week_competition.lcp_06_take_coins;

/**
 * @author chenglong.yu
 * created on 2020/9/17
 */
public class Solution {

    public int minCount(int[] coins) {
        //输入肯定有效，不用判空处理
        int cnt = 0;
        for (int i = 0; i < coins.length; i++) {
            cnt += coins[i] / 2 + coins[i] % 2;
        }
        return cnt;
    }
}
