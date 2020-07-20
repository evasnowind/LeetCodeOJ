package solution.lc_3_longest_substring_without_repeating_char;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/5/2
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Set<Character> scannedChars = new HashSet<>();
        int i = 0, j = 0, maxLength = 0;

        while(j < s.length()) {
            if (!scannedChars.contains(s.charAt(j))) {
                scannedChars.add(s.charAt(j));
                maxLength = Math.max(maxLength, scannedChars.size());
                j += 1;
            } else {
                scannedChars.remove(s.charAt(i));
                i += 1;
            }
        }

        return maxLength;
    }
}
