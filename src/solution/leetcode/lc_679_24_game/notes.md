
# 679. 24 Game

Category	Difficulty	Likes	Dislikes
algorithms	Hard (45.60%)	735	152

Tags
depth-first-search

Companies
google

### Description  

You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
```
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
```

Example 2:
```
Input: [1, 2, 1, 2]
Output: False
```

Note:
```
- The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
- Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
- You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.

# Thinking  

1、暴力计算
元素就4个，可能性比较少。于是有人采用了直接手工列出所有可能的策略，不过要注意交换律。

https://leetcode-cn.com/problems/24-game/solution/bao-li-fa-qing-xi-ming-liao-by-helloworld-o/

2、回溯/BFS
遍历所有可能性时，常见就是用回溯/BFS
https://leetcode-cn.com/problems/24-game/solution/24-dian-you-xi-by-leetcode-solution/