# 154. Find Minimum In Rotated Sorted Array  

Category	Difficulty	Likes	Dislikes
algorithms	Hard (40.37%)	762	202

Tags
array | binary-search

Companies
Unknown

### Description  

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:
```
Input: [1,3,5]
Output: 1
```

Example 2:
```
Input: [2,2,2,0,1]
Output: 0
```

Note:  
- This is a follow up problem to Find Minimum in Rotated Sorted Array.
- Would allow duplicates affect the run-time complexity? How and why?

# Thinking  

看到有序数组，明显需要用到二分。接下来就需要如何使用二分模板，逐个情况分析：
```
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                //说明当前mid在左半边，比right元素要高，可以忽略左边。搜索区间[mid+1, high]
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                //说明当前mid在右半边，比right元素要低，需要忽视右边，搜索区间 [low, mid]
                //错误写法：right = mid - 1 为何？
                right = mid;
            } else if (nums[mid] == nums[right]) {
                /*
                可能出现多个相等元素的情况，此时不一定mid就是解，可能刚好mid right相等、但最小值还比他们小。
                此时可以忽略right，往左边挪动一下
                 */
                right = right - 1;
            }
        }
        return nums[left];
```