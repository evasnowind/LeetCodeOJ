# 67. Add Binary  


Category	Difficulty	Likes	Dislikes
algorithms	Easy (43.11%)	1705	268
Tags
math | string

Companies
facebook

### Description  
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
```
Input: a = "11", b = "1"
Output: "100"
```

Example 2:
```
Input: a = "1010", b = "1011"
Output: "10101"
 ```

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.


# Thinking  

不用思考，直接模拟二进制算法即可。

只需留意字符串索引位置、需要对齐。

注意，纯数学算法上，我们可以采用先将低位、位数相同的部分相加，但在程序实现时，不可以利用较短字符串的长度作为公共相加范围的区间，因为字符串的最低位是从 `字符串长度-1`的位置开始的。
