# Move Zeros  

Category	Difficulty	Likes	Dislikes
algorithms	Easy (57.24%)	3482	115
Tags
array | two-pointers

Companies
bloomberg | facebook

### Description  
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

# Thinking  

本题有多种解题思路：

### 思路1：两个指针，分别指向非零位置、零位置，逐步交换

基本思路很容易，但实现使用可以有多种实现：

#### 思路1.1 
先将非0元素搬运到前半部分，等第一遍遍历完成后，将后面的元素全部置为0
```
	public void moveZeroes(int[] nums) {
		if(null == nums || 0 == nums.length) return;
		int insertIdx = 0;
		for(int num : nums){
			if(0 != num){
				nums[insertIdx++] = num;
			}
		}
		while(insertIdx < nums.length){
			nums[insertIdx++] = 0;
		}
    }
```

#### 思路1.2
在上面基础之上，进一步优化，不用拷贝，直接交换当前0、与后面的非0元素，这样可以避免第2个循环，代码如下：
```
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = tmp;
                lastNonZeroFoundAt += 1;
            }
        }
    }
```
