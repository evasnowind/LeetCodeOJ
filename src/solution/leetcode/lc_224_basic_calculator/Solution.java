package solution.leetcode.lc_224_basic_calculator;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/3/10
 */
public class Solution {
    /**
     * https://leetcode-cn.com/problems/basic-calculator/solution/ji-ben-ji-suan-qi-by-leetcode-solution-jvir/
     *
     * @param s
     * @return
     */
    public int calculate(String s) {

        //保存当前阶段的符号
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                //利用栈来获取当前阶段的符号。
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                //保存整个括号内的符号
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                //计算出当前数字
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                //
                ret += sign * num;
            }
        }

        return ret;
    }
}
