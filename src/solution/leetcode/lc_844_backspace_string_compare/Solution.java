package solution.leetcode.lc_844_backspace_string_compare;

/**
 * @author chenglong.yu
 * created on 2020/10/19
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        String str1 = helper(S);
        String str2 = helper(T);
        return str1.equals(str2);
    }

    private String helper(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
