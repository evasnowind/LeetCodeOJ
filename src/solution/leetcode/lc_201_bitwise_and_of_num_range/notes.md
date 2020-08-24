# 201. Bitwise AND of Numbers Range

Category	Difficulty	Likes	Dislikes
algorithms	Medium (39.04%)	1081	126

Tags
bit-manipulation

Companies
Unknown

### Description  

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
```
Input: [5,7]
Output: 4
```

Example 2:
```
Input: [0,1]
Output: 0
```

# Thinking  

## 思路1：暴力破解  
  
挨个遍历所有数字、进行与操作。
但当区间比较大时这将超时。

## 思路2：利用求公共前缀的思路

由于只要有一位是0，所有数字在该位上的与操作结果都是0。问题可以转化为：找到这个区间内所有数字的最长公共前缀，因为非公共部分是既有0、又有1。
有m n是这个区间的最小、最大值，只用求这两个即可获得所有数字的最长公共前缀。

而求最长公共前缀有两种思路：
1、m n移位运算，算出移动多少位时两者相等
2、利用n&(n-1)可以消除n末尾1，不断消减n末尾的1，直至n<=m