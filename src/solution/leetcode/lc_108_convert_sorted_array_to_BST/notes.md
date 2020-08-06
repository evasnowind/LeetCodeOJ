# 108. Convert Sorted Array To BST

Category	Difficulty	Likes	Dislikes
algorithms	Easy (56.20%)	2361	209
Tags
tree | depth-first-search

Companies
airbnb

### Description  

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 ```

### Thinking  

解析：首先得明确题目要求 height balanced BST，详细定义可以参见下面帖子 https://discuss.leetcode.com/topic/718/the-definition-of-height-balanced-bst
基本就是左右子树高度差不能超过1的二叉搜索树（参见平衡二叉树定义）。
思路：输入参数是一个有序数组，看到有序这俩字就应该联想是否可能用到二分的思想。
要求输出一个棵树，创建树的过程本身可以用递归实现。主要需要考虑创建什么样的树。
容易根据BST特点，联想到：取数组中位数作为根，必然满足“左右子树高度差不能超过1的二叉搜索树”这一要求。
接下来就按照递归模板写代码即可，需要注意每次从数组中获取根时，都要取数组中位数。

```
TreeNode createBst(int[] nums, int low, int high)
    //结束条件
    if (low > high) {
        return null;
    }
    //递归下降条件
    int mid = low + (high - low) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = createBst(nums, low, mid - 1);
    root.right = createBst(nums, mid + 1, high);
    return root;
```