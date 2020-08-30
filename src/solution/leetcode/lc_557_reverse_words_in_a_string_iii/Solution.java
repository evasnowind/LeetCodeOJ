package solution.leetcode.lc_557_reverse_words_in_a_string_iii;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenglong.yu
 * created on 2020/8/30
 */
public class Solution {

    public String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        char[] chs = s.toCharArray();
        int i = 0;
        while (i < chs.length) {
            while (i < chs.length && chs[i] == ' ') {
                builder.append(chs[i++]);
            }

            StringBuilder tmp = new StringBuilder();
            while(i < chs.length && chs[i] != ' ') {
                tmp.append(chs[i++]);
            }
            if (tmp.length() > 0) {
                tmp.reverse();
                builder.append(tmp);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
//        String s = "Let's take LeetCode contest";
//        Solution solution = new Solution();
//        System.out.println(solution.reverseWords(s));

        List<Integer> test = Arrays.asList(1,2,3,4);
        List<Integer> list =test.stream().filter(t -> t > 4).collect(Collectors.toList());
        System.out.println(list);
    }
}
