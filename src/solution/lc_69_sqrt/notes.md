# Description  

### Tags  
math | binary-search

### Companies  
apple | bloomberg | facebook

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:  
```
Input: 4
Output: 2
```

Example 2:  
```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
```

# Thinking  
## 思路1：暴力计算  
从i=1,2,...开始，计算i^2，看是否等于或是超出目标值
问题：
- i^2 可能非常大，会溢出
- 溢出问题至少可以解决，但这种从1开始逐个暴力计算的方法，显然计算量非常大，会超时

## 思路2：二分查找  

本题目提示使用二分查找，并且其实整个过程也明显是一个逐渐逼近的过程，直观上很容易理解这种思路。

套用二分查找公式，每次计算mid对应的平方，与传入x做比较。需要注意的是：  
- 边界值的选择，此处采用了https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/ 提到的二分查找模块，取右中位数
- 可以进一步优化：可以每次比较mid 与 x/mid的值，参考这里 https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution

## 思路3：牛顿迭代法  

适合数学好的童鞋，反正我是想不到，请参考https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/

