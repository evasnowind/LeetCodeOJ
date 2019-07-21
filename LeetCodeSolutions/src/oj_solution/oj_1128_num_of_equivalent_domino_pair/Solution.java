package oj_1124_num_of_equivalent_domino_pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu@100credit.com
 * created on 2019/7/21
 */
public class Solution {
    /**
     *
     *
     * https://leetcode.com/problems/number-of-equivalent-domino-pairs/discuss/340022/JavaC%2B%2BPython-Easy-and-Concise
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}
