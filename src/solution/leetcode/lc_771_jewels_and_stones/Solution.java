package solution.leetcode.lc_771_jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/10/2
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jSet = new HashSet<>();
        char[] jChs = J.toCharArray();
        for (char ch : jChs) {
            jSet.add(ch);
        }

        int cnt = 0;
        for (char ch : S.toCharArray()) {
            if (jSet.contains(ch)) {
                cnt++;
            }
        }
        return cnt;
    }
}
