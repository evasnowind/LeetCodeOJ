# Description  

Implement pow(x, n), which calculates x raised to the power n (xn).
```
Example 1:

Input: 2.00000, 10
Output: 1024.00000
```
```
Example 2:

Input: 2.10000, 3
Output: 9.26100
```

```
Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```

Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]

# Thinking  

## 思路1：暴力求解  

首先能想到的就是一个循环，x不断相乘。这是笨方法，但可以想见肯定不是题目要求的，会超时，需要优化。

## 思路2：使用二分的方式优化  

题目的tag中提示了binary search，同时呢，我们知道 x^4 = (x^2)^2
于是呢，可以将每次相乘的操作优化成：每次计算x^2, n/2，减少迭代次数，直至n=1。当然，此处需要考虑边界条件：
- n = 0 肯定值为1
- n < 0 可以通过将 （x= 1/x, n=-n）转换一下，以便统一计算

总结一下，本题就是靠数学呢，稍微加了点二分的思路。跟求69 sqrt的题目类似。
