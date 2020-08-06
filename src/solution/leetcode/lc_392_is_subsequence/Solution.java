package solution.leetcode.lc_392_is_subsequence;

/**
 * @author chenglong.yu
 * created on 2020/7/27
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        if (null == t || null == s) {
            return false;
        }

        int tLen = t.length(), sLen = s.length();
        int i = 0, j = 0;
        while(i < tLen && j < sLen) {
            if (s.charAt(j) == t.charAt(i)) {
                j += 1;
            }
            i += 1;
        }
        return j == sLen;
    }
}
