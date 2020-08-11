# 198. House Robber  


Category	Difficulty	Likes	Dislikes
algorithms	Easy (41.70%)	4944	154

Tags
dynamic-programming

Companies
airbnb | linkedin

### Description  

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


Example 1:
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
```

Example 2:
```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 ```

Constraints:
```
0 <= nums.length <= 100
0 <= nums[i] <= 400
```

# Thinking  

题目求最大值，且该题目中数组都是非负数，容易联想到可以用动态规划。
接下来就是，如何定义动态规划的状态、状态转移方程？  
- 状态：f(n) 首先会想用`截止到n的最大值`，但是这个跟后面的状态关系不大、没有用到必须间隔一个元素的条件。那么可以尝试定义： `抢劫第n个屋子时所得的金额`
- 初始状态：f(0)= nums[0], f(1)=nums[1]
- 状态转移方程：f(n) = max(nums[n] + f(n-2), f(n-1))

状态转移方程弄明白后，就简单了，可以看出不用定义数组，只需要记录n-1 n-2的计算结果
