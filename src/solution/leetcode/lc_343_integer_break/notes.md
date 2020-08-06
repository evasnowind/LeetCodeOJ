# 343. Integer Break  

Category	Difficulty	Likes	Dislikes
algorithms	Medium (49.60%)	988	221

Tags
math | dynamic-programming

Companies
Unknown

### Description  

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:
```
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
```

Example 2:
```
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
```

Note: You may assume that n is not less than 2 and not larger than 58.

# Thinking  
首先，这道题目本身要求最值，并且题目思想中可以看出一定的递推性，可以推测中可以用动态规划。
接下来就是怎么用DP。
定义一个dp[n+1]，dp[i]表示i拆分后所有正整数的乘积。
显然：
dp[0] = 0
dp[1] = 0

i >= 2时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：

将 i 拆分成 j 和 i-j的和，且 i-j不再拆分成多个正整数，此时的乘积是 j×(i−j)；

将 i 拆分成 j 和 i-j的和，且 i-j继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。

注意这种用dp数据作为备忘录来加快求解过程时，需要从最小的值开始不断计算更大的值，因而外层还需要一个循环。
最终结果参见代码。

参考：https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
