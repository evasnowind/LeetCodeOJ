package solution.leetcode.lc_1118_number_of_days_in_month;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/10/29
 */
public class Solution {

    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = T.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = new int[]{73,74,75,71,69,76};
        int[] res = s.dailyTemperatures(t);
        System.out.println(res);
    }
}
