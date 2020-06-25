# 5 Longest Palindromic Substring

Category	Difficulty	Likes	Dislikes
algorithms	Medium (29.03%)	6348	507
Tags
string | dynamic-programming

Companies
amazon | bloomberg | microsoft

### Description  
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

Example 2:
```
Input: "cbbd"
Output: "bb"
```

# Thinking  

## 思路1：暴力搜索  
从仅包含1个字符的子串开始，找出所有字串并判断是否为回文字符串，如果时则更新最长子串。
简单粗暴，但很明显时间略长、提交leetcode基本肯定会超时。

## 思路2：动态规划  

这个我就不太懂了，正在看，先记录下，有待后续补充。
参见该链接：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
