# 128 Longest Consecutive Sequence  

Category	Difficulty	Likes	Dislikes
algorithms	Hard (44.26%)	3072	170

Tags
array | union-find

Companies
facebook | google

### Description  
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:
```
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

# Thinking  

## 思路1：暴力搜索  

容易联想到，一个双重循环，从第1个元素开始找每个元素对应的连续子序列，大致思路如下

```
longestLen = 0
for a[i] in arr[0, len - 1]
    
    for a[j] in arr[0, len - 1]
        找a[i]起始的连续子数组。此处注意，只需要往一个方向找即可，不用a[i] + 1、a[i] - 1两个方向都找，因为一个方向自然就会覆盖所有。
    比较最大值，赋值给longestLen
``` 

明显，时间复杂度O(n^2)

## 思路2：空间换时间   
引入额外的空间、预先算出一些值，简化核心逻辑的时间复杂度，是很重要的一个思路。在本题中，可以将所有元素放到一个Set中，以便优化能内层循环、在O(1)时间内就可以知道当前元素的前驱、后继是否在原来的数组中存在。

但这仍有问题，即最坏情况下，每个元素内层循环都要遍历一次。此时时间复杂度仍是O(n^2)。

参考https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/  的优化方式，为了跳过重复计算，可以判断a[i] - 1 是否已经在Set中存在，如果不存在我们才从头开始遍历；若存在说明该元素在别的连续子序列中、不是第一个，那我们就不用重复检索，在其他元素的检索过程中自然会遇到这个元素。

具体实现参见源码。