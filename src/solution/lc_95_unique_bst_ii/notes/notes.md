# 95 Unique Binary Search Trees II

Category	Difficulty	Likes	Dislikes
algorithms	Medium (39.26%)	2220	159

Tags
dynamic-programming | tree

Companies
Unknown

### Description  

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
```
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]

Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

Constraints:
0 <= n <= 8

# Thinking  

有待进一步分析，但整体思路上用到了动态规划，需要写状态转移方程。
