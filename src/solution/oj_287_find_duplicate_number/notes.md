# 287 Find The Duplicate Number  


Category	Difficulty	Likes	Dislikes
algorithms	Medium (53.28%)	4089	508

Tags
array | two-pointers | binary-search

Companies
bloomberg

### Description  
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
```
Input: [1,3,4,2,2]
Output: 2
```

Example 2:
```
Input: [3,1,3,4,2]
Output: 3
```

Note:

1. You must not modify the array (assume the array is read only).  
2. You must use only constant, O(1) extra space.  
3. Your runtime complexity should be less than O(n^2).  
4. There is only one duplicate number in the array, but it could be repeated more than once.  

# Thinking  

## 思路1：暴力搜索  

由于要求空间复杂度不能超过O(1)，所以不能使用类似HashSet保存已有数组来判断的思路。  
最愚笨的方法，双重循环，外层挨个遍历，内层从头开始，看是否发生重复，但这种思路时间复杂度为O(n^2)，又不满足时间复杂度的要求。

显然，直接暴力破解是无法解决的。

## 思路2：排序后遍历  
这个思路相对容易想到，遇到数组先排序，反正排序用快排的话，不过是将时间复杂度提升到至少O(nlgn)的级别。
排序后，就很容易了：两个重复数字必然相邻，判断相邻数字相等的情况，就找到了题目所求。

## 思路3：二分查找  

## 思路4：抽屉原理  

## 思路5：位运算  

