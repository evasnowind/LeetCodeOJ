# Description

## tag
hash-table | two-pointers | string | sliding-window



Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"  
Output: 3   
Explanation: The answer is "abc", with the length of 3.
   
Example 2:  
Input: "bbbbb"    
Output: 1  
Explanation: The answer is "b", with the length of 1.
    
Example 3:  
Input: "pwwkew"  
Output: 3  
Explanation: The answer is "wke", with the length of 3.   
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.  
             
            
# thingking

### 初步思考：暴力搜索

创建一个hashset，用于保存已经扫描过的字符。从第1个字符开始往后扫描，看字符串，直至出现相同字符则结束扫描。
然后从第2个字符重复上述流程。
记录已得到的字符串，找出最大的即可。
空间O(n)
时间O(n^2)

### 进一步优化
上述过程没有问题，但有很多重复计算的地方：  
1、问题并没有要求给出最长串是什么、只需要最后算出长度即可，所以不用保存实际的最长子串，只需有一个变量计算长度即可  
2、不需要每次都从0开始计算新的子串长度，在上次计算基础之上，只要排除掉上次计算的第1个字符，就可以继续往下计算  
上述思路来源于：https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet  

综上，思路：   
1、一个set，保存当前已扫描过的字符，实际上是按照字符串顺序逐步放进去的、逐步弹出的（虽然好像是FIFO，但set速度更快）  
2、两个指针变量i, j，分别保存当前子串从整个字符串哪个位置开始计算、当前正在扫描的字符位置  
3、当前已得到的子串最长长度  max

实际上上述用到了滑动窗口的思想，具体可以参考：https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/  
滑动窗口常见于数组、字符串相关问题。     

优化后：  
空间O(k)   滑动窗口的大小k
时间O(n)
