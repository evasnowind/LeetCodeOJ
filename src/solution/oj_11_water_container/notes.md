# 11 Water Container  


Category	Difficulty	Likes	Dislikes
algorithms	Medium (49.63%)	5394	555
Tags
array | two-pointers

Companies
bloomberg

### Description  

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 

# Thinking  

### 思路1：暴力计算  
直接计算出所有组合的值。
很明显，这样的计算时间复杂度比较高。

### 思路2 逐步逼近最优解  

直接翻的题解，具体证明过程参见 https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/

既然证明从左右逐步逼近有效，那么就可以开写代码：

第1版：
```
	public int maxArea(int[] height) {
		if (null == height || height.length == 0) {
			return 0;
		}

		int maxArea = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int minH = Math.min(height[i], height[j]);
			int curArea = minH * (j - i);
			if (height[i] == minH) {
				while(i < j) {
					i += 1;
					if (height[i] > minH) {
						break;
					}
				}
			} else {
				while(i < j) {
					j -= 1;
					if (height[j] > minH) {
						break;
					}
				}
			}
			if (curArea > maxArea) {
				maxArea = curArea;
			}
		}

		return maxArea;
	}
```
代码略丑陋，注意边界条件，必须``i < j`，否则可能出现越界问题，并且从题目情景上看也不可能出现i=j。
另外，从第1版代码中可以看到，有些代码可以进一步精简，精简后的效果：
```
public int maxArea(int[] height) {
    if (null == height || height.length == 0) {
        return 0;
    }

    int maxArea = 0;
    int i = 0, j = height.length - 1;
    while (i < j) {
        int minH = Math.min(height[i], height[j]);
        maxArea = Math.max(minH * (j - i), maxArea);
        //下面的判断有相等，主要是为了保证第1次时能进入该循环，然后只要height[i]比当前刚找到minH要小，i就一直向前之后，保证找到一个比minH更高的值
        while(height[i] <= minH && i < j) {
            i += 1;
        }
        while(height[j] <= minH && i < j) {
            j -= 1;
        }
    }

    return maxArea;
}
```