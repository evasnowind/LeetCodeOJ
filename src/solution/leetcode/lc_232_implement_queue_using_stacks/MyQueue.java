package solution.leetcode.lc_232_implement_queue_using_stacks;

import java.util.Stack;

/*
 * 思路：用栈实现队列，比较常规的题目，基本思路就是用两个栈，
 * 		将数据从一个栈弹出、放入另一个栈，即可获得与队列一样的顺序。
 * 		在这一思路下，调整push pop peek empty等内部实现即可
 */
public class MyQueue {
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output = new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        while(!output.isEmpty()){
        	input.push(output.pop());
        }
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!input.isEmpty()){
        	output.push(input.pop());
        }
        output.pop();
    }

    // Get the front element.
    public int peek() {
    	while(!input.isEmpty()){
    		output.push(input.pop());
    	}
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
