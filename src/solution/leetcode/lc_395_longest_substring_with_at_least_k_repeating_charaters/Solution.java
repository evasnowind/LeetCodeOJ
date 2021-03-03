package solution.leetcode.lc_395_longest_substring_with_at_least_k_repeating_charaters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2021/2/27
 */
public class Solution {

    public int longestSubstring(String s, int k) {
        if (null == s || s.length() < k) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int len = chs.length, max = 0;
        int left = 0, right = 0;
        Map<Character, Integer> cntMap = new HashMap<>();
        while(right < len) {

            while((right+1) < len && chs[right] == chs[right+1]) {
                right++;
            }
            int cnt = right - left + 1;

            max = Math.max(cnt, max);

            right++;
            left = right;
        }
        return max;
    }
}
