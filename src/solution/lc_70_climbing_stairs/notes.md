# 70. Climbing Stairs  

Category	Difficulty	Likes	Dislikes
algorithms	Easy (46.56%)	4118	133

Tags
dynamic-programming

Companies
adobe | apple

### Description  
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:
```
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

Example 2:
```
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

# Thinking   
经典题目。
首先，分析题目，状态转移函数  f(n) = f(n-1) + f(n-2)
f(n)表示n个台阶的走法，那么先拆解成子问题，走一步的时候，可以走1个台阶（剩余台阶走法为f(n-1)），也可以走2个台阶（剩余台阶走法为f(n-2)）。两个方式的走法加一起即为题解。

从上述状态转移函数可以看出，实际上就是斐波那契数列。
代码实现有2种：
### 思路1：递归实现  
递归结束条件：n=1时f(n)=1;n=0时f(n)=0
效率略低

### 思路2：直接循环，逐步累加到n
这样效率最高，代码如下
```java
class Solution {
    public int climbStairs(int n) {
        if (0 >= n) {
            return 0;
        } else if (1 == n) {
            return 1;
        } else if (2 == n) {
            return 2;
        }
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allSolution = 0;
        for (int i = 2; i < n; i++) {
            allSolution = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allSolution;            
        }
        return allSolution;
    }
}
```

