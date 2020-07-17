Search Insert Position
Category	Difficulty	Likes	Dislikes
algorithms	Easy (41.61%)	2421	256
Tags
array | binary-search

Companies
Unknown

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
```
Input: [1,3,5,6], 5
Output: 2
```

Example 2:
```
Input: [1,3,5,6], 2
Output: 1
```

Example 3:
```
Input: [1,3,5,6], 7
Output: 4
```

Example 4:
```
Input: [1,3,5,6], 0
Output: 0
```

# Thinking  
  
实际上就是二分查找寻找左边界。
注意边界情况
比如说
(1) []
(2) [1]
(3) [1,2,3,3,3,4]这种连续多个元素的情况，target在中间
(4) [1,2,3,3,3,4]这种连续多个元素的情况，target在中间
(5) [1,2,3,3,3,4]这种连续多个元素的情况，target在起始位置
(6) [1,2,3,3,3,4]这种连续多个元素的情况，target在结束位置
(7) [1,2,3,3,3,4]这种连续多个元素的情况，target小于起始元素
(8) [1,2,3,3,3,4]这种连续多个元素的情况，target大于终止元素
 
 有两种模板
 (1) 搜索区间都是闭合的
 (2) 搜索区间左开右闭（对于寻找左边界、右边界可能更常用）
 不同模板结束条件务必注意。
 
 
 (1) 搜索区间都是闭合的
 
 ```
int left = 0, right = nums.length - 1;
while (left <= right) {
    mid = left + (right - left) / 2;
    if (nums[mid] == target) {
// 收缩右侧边界
        right = mid - 1;
    } else if (nums[mid] > target) {
        // 搜索区间变为 [left, mid-1]
        right = mid - 1;
    } else if (nums[mid] < target) {
        // 搜索区间变为 [mid+1, right]
        low = mid + 1;
    }
}

// 检查出界情况
if (left >= nums.length || nums[left] != target)
    return -1;
```