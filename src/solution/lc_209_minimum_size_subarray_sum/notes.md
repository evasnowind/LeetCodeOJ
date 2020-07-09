# 209. Minium Size Subarray Sum  

Category	Difficulty	Likes	Dislikes
algorithms	Medium (37.18%)	2284	106
Tags
array | two-pointers | binary-search

Companies
facebook

### Description  

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 
```
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
```

Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

# Thinking  

## 思路1：暴力计算  
设置两个指针start end，从start开始，计算[start, end]区间和，若满足>=s的条件，则停止，获得最小长度，直至将整个数组遍历完。
参见Solution中的minSubArrayLen0
时间：O(n^2)
空间：O(1)

## 思路2：双指针，滑动窗口的思想  

思路1没有利用上次迭代已经计算过的结果。通过滑动窗口的思路，每次计算下个窗口时，尽可能利用上个窗口的计算结果。
于是有了下面的思路：
>初始状态下，start 和end 都指向下标 0，sum 的值为 0。
>每一轮迭代，将 nums[end] sum，如果sum≥s，则更新子数组的最小长度（此时子数组的长度是end−start+1，然后将nums[start] 从 sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end 右移。

引自：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/


## 思路3：空间换时间，前缀和  

有点没太理解，大家参考这里
https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/