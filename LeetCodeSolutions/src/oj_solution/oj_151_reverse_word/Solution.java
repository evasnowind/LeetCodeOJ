package oj_151_reverse_word;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/4/10
 */
public class Solution {

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    /**
     * 印象里之前剑指offer里有收录的一道题目，思路比较简单，整个字符串反转，然后每个单词分别反转，
     * 对于C/C++这种字符串可变的，可以不用新建字符串、原地反转。
     *
     * 用java api现有接口就可以实现，此处拿一个手写实现抄一下
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/
     *
     * java api版本：
     public String reverseWords(String s) {
     // 除去开头和末尾的空白字符
     s = s.trim();
     // 正则匹配连续的空白字符作为分隔符分割
     List<String> wordList = Arrays.asList(s.split("\\s+"));
     Collections.reverse(wordList);
     return String.join(" ", wordList);
     }
     *
     * @param sb
     * @param left
     * @param right
     */
    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

    public String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }
}
