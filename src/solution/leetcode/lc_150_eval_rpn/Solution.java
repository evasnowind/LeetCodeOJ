package solution.leetcode.lc_150_eval_rpn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/3/20
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        for(String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                Integer res = -1;
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        break;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }


    private boolean isNumber(String token) {
        return !"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token);
    }
}
