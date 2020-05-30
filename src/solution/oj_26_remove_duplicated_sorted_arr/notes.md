# 26 Remove Duplicated From Sorted Array  

Category	Difficulty	Likes	Dislikes
algorithms	Easy (44.05%)	2311	4787
Tags
array | two-pointers

Companies
bloomberg | facebook | microsoft

### Description  

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```


Example 2:
```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```

#### Clarification:  

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:
```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

# Thinking  

简单题，该题目可以Move Zero题目一起看。

本题基本思路：
注意关键点：数组有序
两个指针（双指针这种思想真的很有用啊~）
```
    指针p1指向当前数组第1个元素
    指针p2指向数组第2个元素，从这个位置开始，挨个遍历后续元素：
        1. 如果与p1相同，说明当前还是相同元素，不用操作
        2. 若p2与p1不同，则p1向前挪动一位，交换p1与p2，然后p2继续向前遍历
    遍历结束后，p1指向的是不重复数组的最后一个元素
```
