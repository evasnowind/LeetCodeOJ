package solution.leetcode.lc_1431_most_candies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/6/1
 */
public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandy = Math.max(maxCandy, candies[i]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= maxCandy);
        }
        return res;
    }
}
