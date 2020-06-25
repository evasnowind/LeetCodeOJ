# 394. Decode String  

Category	Difficulty	Likes	Dislikes
algorithms	Medium (48.65%)	2845	146

Tags
stack | depth-first-search

Companies
google | yelp

### Description  

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:
```
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

# Thinking  

首先，这道题目很明显，需要用到括号匹配，而括号的匹配，需要用到栈。自己创建一个栈，或是递归，都可以。  
这就带来两种思路：

## 思路1：自己维护栈  
维护两个栈（维护1个栈来实现也可以试试，我自己试过，略麻烦，放弃了），分别保存：
- 当前串的重复次数  
- 上一次计算所获得的子串    

暂时没想清，TODO 


## 思路2：递归  

看leetcode题解，用了DFS。有待深入研究TODO。

https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/