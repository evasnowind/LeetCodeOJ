package solution.leetcode.lc_1006_clumsy_factorial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/4/1
 */
public class Solution {

    /**
     * 加减乘除的计算，可以参考计算器的实现，
     * 那可以利用栈来实现先乘除、后算加减的逻辑。
     *
     * @param N
     * @return
     */
    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();

        stack.push(N);

        N--;

        int index = 0;
        while(N > 0) {
            /*
            有乘除，则先弹出栈，计算完再压栈。
            加减则直接压栈，等到最后将整个栈中的数字加和即可（这种做法要求减法时压入一个相反数）。
             */
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            N--;
            index++;
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
