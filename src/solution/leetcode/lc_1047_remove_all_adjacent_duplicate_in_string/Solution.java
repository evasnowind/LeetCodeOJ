package solution.leetcode.lc_1047_remove_all_adjacent_duplicate_in_string;

/**
 * @author chenglong.yu
 * created on 2021/3/9
 */
public class Solution {

    public String removeDuplicates(String S) {
        if (null == S || S.length() == 0) {
            return S;
        }

        StringBuilder builder = new StringBuilder();
        int top = -1;
        /*
        将StringBuilder当做栈来使用，每次压栈的时候，比较
        前一个字符，看是否相等，如果相等，则将StringBuilder
        最后一个字符弹出，然后继续下一次循环即可。
         */
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (top >= 0 && builder.charAt(top) == ch) {
                /*
                builder已经压入了字符，则与最后一个字符进行比较，
                如果相等说明有重复，则删除最后一个字符，对应索引
                位置减1；
                 */
                builder.deleteCharAt(top);
                top--;
            } else {
                /*
                目前builder是空的，肯定没有重复，直接压入即可，
                注意索引位置的维护。
                 */
                builder.append(ch);
                top++;
            }
        }

        return builder.toString();
    }
}
