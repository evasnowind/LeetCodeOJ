package solution.week_competition.w20201011_n210;

import java.net.Socket;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/10/11
 */
public class Solution2 {

    public int maxDepth(String s) {
        if (null == s || s.trim().equals("")) {
            return 0;
        }
        String trimStr = s.trim();
        if (trimStr.length() == 1 && trimStr.charAt(0) != '(' && trimStr.charAt(0) != ')') {
            return 0;
        }

        Deque<Character> stack = new LinkedList<>();
        char[] chs = trimStr.toCharArray();
        int cnt = 0;
        int maxDepth = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(chs[i]);
                cnt++;
                maxDepth = Math.max(cnt, maxDepth);
            } else if (chs[i] == ')') {
                stack.pop();
                cnt--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String str = null;
        str = "1";
        int res = 0;
//        res = s.maxDepth(str);
//        System.out.println(res);
//        str = "(1+(2*3)+((8)/4))+1";
//        res = s.maxDepth(str);
//        System.out.println(res);
//        str = "(1)+((2))+(((3)))";
//        res = s.maxDepth(str);
//        System.out.println(res);
//        str = "1+(2*3)/(2-1)";
//        res = s.maxDepth(str);
//        System.out.println(res);
        str = "3*4-2*5";
        res = s.maxDepth(str);
        System.out.println(res);
    }
}
