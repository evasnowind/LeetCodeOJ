# 136 Single Number  


Category	Difficulty	Likes	Dislikes
algorithms	Easy (64.74%)	4152	153
Tags
hash-table | bit-manipulation

Companies
airbnb | palantir

### Description  
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:  
```
Input: [2,2,1]
Output: 1
```

Example 2:  
```
Input: [4,1,2,1,2]
Output: 4
```

# Thinking  

很经典的题目。实际上考察的是对于异或运算的理解与运用：两个相同的数字进行异或，得到的结果为0。
那么，根据题目，数组中除了一个数字，其他数据都出现了两次，刚好可以整体异或运算，其他数字都被相互抵消，剩下的就是所求值。

与之类似的另一道经典题目是 260. Single Number III.可以相互参考下