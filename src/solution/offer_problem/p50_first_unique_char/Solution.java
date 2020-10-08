package solution.offer_problem.p50_first_unique_char;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/10/8
 */
public class Solution {
    public char firstUniqChar(String s) {
        int[] cntArr = new int[26];
        Arrays.fill(cntArr, 0);

        if (null == s || s.length() == 0) {
            return ' ';
        }

        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (cntArr[ch - 'a'] == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
