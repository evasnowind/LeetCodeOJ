package solution.oj_225_implement_stack_using_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	/*
	 * 常见的方式有两种，用两个队列或是用一个队列，单个队列方法参见
	 * https://discuss.leetcode.com/topic/19227/a-simple-c-solution
	 */
	private Queue<Integer> queue1 = new LinkedList<Integer>(),queue2 = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
    	if(queue1.isEmpty()){
    		queue1.add(x);
    		while(!queue2.isEmpty()){
    			queue1.add(queue2.poll());
    		}
    	} else {
    		queue2.add(x);
    		while(!queue1.isEmpty()){
    			queue2.add(queue1.poll());
    		}
    	}
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(queue1.isEmpty()){
    		queue2.poll();
    	} else{
    		queue1.poll();
    	}
    }

    // Get the top element.
    public int top() {
        if(queue1.isEmpty()){
        	return queue2.peek();
        } else {
        	return queue1.peek();
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
    	if(queue1.isEmpty() && queue2.isEmpty()){
    		return true;
    	} else {
    		return false;
    	}
    }
}
