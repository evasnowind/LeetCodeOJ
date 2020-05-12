# Description  


Category	Difficulty	Likes	Dislikes
algorithms	Easy (43.28%)	3096	301

### Tags  
stack | design

### Companies
amazon | bloomberg | google | snapchat | uber | zenefits


Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- getMin() -- Retrieve the minimum element in the stack.
 

Example 1:
```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.


# Thinking    

#### 思路1：两个栈，其中一个专门用于维护当前最小值  
很明显该思路最简单，而且不需要考虑什么边界情况，但缺点就是占用额外空间，有些浪费

```java
import java.util.Stack;

public class MinStack {

    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    // 思路 1：数据栈和辅助栈在任何时候都同步

    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        // 两个栈都得 pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
```

### 思路2：仍是2个栈，但保存最小值的栈不必每次压栈都更新  

可以看到，思路1的最小值栈，每次压栈都更新的话，将会保存大量重复数据。结合题目，我们只需要保存最小值，则：  
- 压栈时，只有新压入的值**小于或是等于**当前最小值栈栈顶元素，才压到最小值栈中，这保证了每次最小值栈栈顶都是最小值；  
- 弹栈时，比较要弹出的值，若与最小值栈**相等**，最小值栈才弹出一个元素  

注意此处`相等`这个条件非常关键，这保证了弹出一个元素时，最小值栈栈顶元素一直对应另一个栈当前状态。

```java
class MinStack {
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
```

### 思路3：

来自leetcode 高票答案：

```java
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
```

## 参考资料  
- https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/

