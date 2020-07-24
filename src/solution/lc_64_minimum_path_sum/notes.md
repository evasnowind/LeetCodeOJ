# 64. Minimum Path Sum

Category	Difficulty	Likes	Dislikes
algorithms	Medium (53.14%)	3094	64

Tags
array | dynamic-programming

Companies
Unknown

### Description  

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```

# Thinking  

经典的动态规划问题，题目已限定只能往右、往下走，使得问题简化，按照动态规划解题思路，首先，分析出递归公式：
0. 对于起始元素，显然：
    dp[0][0] = grid[0][0]
1. 对于第0行的所有元素：
    只能从grid[0][0]往右走才能到达，即
    dp[0][j] = dp[0][j-1] + grid[0][j]
2. 对于第0列的所有元素
    只能从grid[0][0]往下走才能到达，即
    dp[i][0] = dp[i-1][0] + grid[i][0]
3. 对于其他元素
    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
    