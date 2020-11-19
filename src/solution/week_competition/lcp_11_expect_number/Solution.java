package solution.week_competition.lcp_11_expect_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/11/21
 */
public class Solution {

    public int expectNumber(int[] scores) {
        /*
        这道题直接理解不能……
         */
        Set<Integer> set = new HashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }
}
