package solution.interview.offer_problem_09_impl_queue_using_stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/6/30
 */
public class CQueue {

    Deque<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        //找到有元素的栈a，将其重新pop、压入另一个栈b,然后新元素压入到b栈顶
        //要保证处于栈顶是队尾的状态
        if (stack1.isEmpty() && stack2.isEmpty()) {
            stack1.push(value);
            return;
        }

        if (stack1.isEmpty()) {
            stack2.push(value);
        } else {
            stack1.push(value);
        }
    }

    public int deleteHead() {
        //找到有元素的栈a，若都为空则返回-1；若有，则先将其pop、压入另一个栈、删除栈顶，然后再pop、压入另一个栈
        //要保证处于栈顶是队尾的状态

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }

        if (stack1.isEmpty()) {
            reverseQueue(stack2, stack1);
            int res = stack1.pop();
            reverseQueue(stack1, stack2);
            return res;
        } else {
            reverseQueue(stack1, stack2);
            int res = stack2.pop();
            reverseQueue(stack2, stack1);
            return res;
        }
    }

    private void reverseQueue(Deque<Integer> s1, Deque<Integer> s2) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }


    /*
    上述不是最优代码，最好的方式参见notes.md

    Deque<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

     */

    public static void main(String[] args) {

    }
}
