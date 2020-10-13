package solution.offer_problem.p59_max_value_in_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenglong.yu
 * created on 2020/10/13
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    /**
     * 分析参见
     * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
     * 不过这个分析不够明晰，图示可以参见这个：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
     */
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while(!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ans = queue.poll();
        if (ans == deque.peekFirst()) {
            deque.pollFirst();
        }
        return ans;
    }
}
