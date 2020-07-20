package solution.lc_394_decode_string;

import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/5/28
 */
public class Solution {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String str = "3[a]2[bc]", res;
        Solution s = new Solution();
//        res = s.decodeString(str);
//        System.out.println("str=" + str + " res=" + res);
//
        str = "3[a2[c]]";
        res = s.decodeString(str);
        System.out.println("str=" + str + " res=" + res);
//
//        str = "2[abc]3[cd]ef";
//        res = s.decodeString(str);
//        System.out.println("str=" + str + " res=" + res);

//        str = "100[leetcode]";
//        res = s.decodeString(str);
//        System.out.println("str=" + str + " res=" + res);
    }
}
