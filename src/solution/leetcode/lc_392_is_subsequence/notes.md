# 392. Is Subsequence

Category	Difficulty	Likes	Dislikes
algorithms	Easy (47.97%)	1551	202

Tags
binary-search | dynamic-programming | greedy

Companies
Unknown

### Description  

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.


Example 1:
```
Input: s = "abc", t = "ahbgdc"
Output: true
```

Example 2:
```
Input: s = "axc", t = "ahbgdc"
Output: false
```

Constraints:
```
0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.
```

# Thinking  

注意题目要判断的是子序列、不是子串。因此，可以采用双指针的方式挨个判断，这个算是贪心的思想。

如果要用动态规划也可以，但感觉略麻烦，并且如果原始数据量很大、所需要的memo也会很占空间。