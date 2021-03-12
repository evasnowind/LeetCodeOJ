package solution.leetcode.lc_331_verify_preorder_serialization_of_a_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/3/12
 */
public class Solution {

    public boolean isValidSerialization(String preorder) {
        Deque<Integer> stack = new LinkedList<>();

        stack.push(1);
        int i = 0;
        int n = preorder.length();
        while(i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                int cur = stack.pop() - 1;
                if (cur > 0) {
                    stack.push(cur);
                }
                i++;
            } else {
                while(i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int cur = stack.pop() - 1;
                if (cur > 0) {
                    stack.push(cur);
                }
                stack.push(2);
            }
        }

        return stack.isEmpty();
    }
}
