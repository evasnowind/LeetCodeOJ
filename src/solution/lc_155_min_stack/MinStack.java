package solution.lc_155_min_stack;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
	/*
	 * 主要麻烦的地方在于压栈/弹栈会导致最小值会变化。
	 * 一般思路：用2个栈，一个执行正常压栈、弹栈操作；另一个记录每次压栈、弹栈时的最小值
	 * 精巧思路：只用1个栈，栈内记录x-min，通过差值记录每次push pop的最小值变化
	 * 
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop=stack.pop();
        
        if (pop<0)  min=min-pop;//If negative, increase the min value
        
    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
	 */
	Stack<Integer> minStack = new Stack<Integer>();
	Stack<Integer> stack = new Stack<Integer>();
	
	/** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
    	stack.push(x);
    	
    	if(minStack.isEmpty()){
    		minStack.push(x);
    	} else {
    		if(minStack.peek() >= x){
    			minStack.push(x);
    		}
    	}
    }
    
    public void pop() {
    	int top = stack.pop();
    	if(!minStack.isEmpty() && top == minStack.peek()) {
    		minStack.pop();
    	}
    }
    
    public int top() {
    	if(!stack.isEmpty()){
    		return stack.peek();
    	}
        return Integer.MAX_VALUE;
    }
    
    public int getMin() {
    	if(!minStack.isEmpty()){
    		return minStack.peek();
    	}
        return Integer.MAX_VALUE;
    }
}
