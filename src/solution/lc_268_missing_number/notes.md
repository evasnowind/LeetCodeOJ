# 268 Missing Number  
Category	Difficulty	Likes	Dislikes
algorithms	Easy (50.78%)	1778	2099

Tags
array | math | bit-manipulation

Companies
bloomberg | microsoft

### Description  

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
```
Input: [3,0,1]
Output: 2
```

Example 2:
```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

# Thinking  
### 思路1：用hashmap保存已有数组

时间O(N)
空间O(N)

### 思路2：排序后挨个找
时间O(NlgN)
空间O(1)或是O(N) 取决于排序算法
需要注意边界条件，出现在第1位或是最后1位需要单独判断。

### 思路3：位运算，利用异或的特性
