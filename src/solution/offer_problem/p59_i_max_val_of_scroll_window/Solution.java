package solution.offer_problem.p59_i_max_val_of_scroll_window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/3/19
 */
public class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k + 1];
        /*
        i表示当前窗口左边界序号， j表示当前窗口右边界序号
        则nums[i-1]表示左边刚刚滑出窗口的元素

         */
        for(int j = 0, i = 1 - k; j < len; i++, j++) {
            //已形成窗口后，如果当前
            if (i > 0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            //删除窗口内所有小于nums[j]的元素，保持双端队列递减，队列第一个元素是最大的
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            //将当前元素压入队列尾
            deque.addLast(nums[j]);
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
