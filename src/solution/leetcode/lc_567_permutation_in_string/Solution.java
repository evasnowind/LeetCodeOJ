package solution.leetcode.lc_567_permutation_in_string;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2021/2/16
 */
public class Solution {

    /**
     * 1、提到字符串排列，很自然会想到用回溯、列出所有排列，
     * 然后看是否是s2的子串。但显然这样的时间复杂度是O(n!)，
     * 成本太高。
     *
     * 2、回过头来再读题，题目实际上只是让我们判断是否为子串，
     * 并没有让我们求出子串具体长什么样子。
     * 那么我们可以考虑，只要s2中的某个子串，子串长度与s1相等、
     * 且该子串中每个字符的个数与s1完全一致，那s1必然是s2的子串。
     * 在这种情况下，只需要求出s2中每个子串的字符出现情况，
     * 而这个涉及连续统计串中的字符出现情况，可以联想滑动窗口。
     * 综上：
     * 2.1 统计s1中字符串出现情况
     * 2.2 统计s2中长度为n（s1的长度）的子串字符出现情况
     * 2.3 滑动窗口，维持窗口长度为n，不断滑动，看比较两个字符数组是否一致
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int n = s1.length();
        char[] ch1 = new char[26];
        char[] ch2 = new char[26];
        for(int i = 0; i < n; i++) {
            ch1[s1.charAt(i) - 'a']++;
            ch2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(ch1, ch2)) {
            return true;
        }
        for(int i = n; i < s2.length(); i++) {
            ch2[s2.charAt(i) - 'a']++;
            ch2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(ch1, ch2)) {
                return true;
            }
        }
        return false;
    }
}
