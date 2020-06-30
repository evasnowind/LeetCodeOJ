# 剑指offer 09. 用栈实现队列  

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：
```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

示例 2：
```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用

# Thinking  

## 思路1：双栈，来回倒，保证有数据的栈处于栈顶是队尾的状态

思路简单，只是多出一些额外的来回倒数据的操作

## 思路2：双栈，一个栈保存已加入数据，另一个保存待弹出数据 

思路1的优化版本，题目只需加入、弹出操作。并不关心数据如何保存。

我们可以这样：
- stack1 按加入顺序保存已有的数据：即按队列方式保存数据，可能是全部数据（没调用过删除），也可能是部分数据（调用过删除操作）  
- stack2 保存待删除的数据
    - 要删除时，先判断stack2是否空，若空先将stack1的数据倒过来，保证有数据，然后再弹出栈顶
    
这样操作的话，stack1、stack2共同组成了所有数据，只是stack1按压入顺序保存数据，stack2则逆序保存、以便保证弹出顺序  

```java
class CQueue {
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
}
```