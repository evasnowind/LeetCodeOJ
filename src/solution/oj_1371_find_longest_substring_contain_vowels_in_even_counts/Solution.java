package solution.oj_1371_find_longest_substring_contain_vowels_in_even_counts;

import java.util.Arrays;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/5/20
 */
public class Solution {

    public int findTheLongestSubstring(String s) {
        //题解参考这里  https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/c-qian-zhui-he-zhuang-tai-ya-suo-xiang-jie-by-yizh/，这道题真无力了………………
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
