# Description

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:
```
    2
   / \
  1   3
```
Input: [2,1,3]     
Output: true    
Example 2:  
```
    5
   / \
  1   4
     / \
    3   6
```

Input: [5,1,4,null,null,3,6]  
Output: false   
Explanation: The root node's value is 5 but its right child's value is 4.

# Thinking

### 思路1  
这道题思路相对其实很简单，实际上我觉得有一个地方算是个小坑，那就是对于BST定义的理解、代码实现，第一次上来看到这题目，容易类似这样（反正我第一次遇到这题是这么写的，捂脸……）
```java
boolean validate(TreeNode root) {
    if (null == root) {
        return true;
    }
    
    if (null != root.left && root.left.val >= root.val) {
        return false;
    }
    if (null != root.right && root.right.val >= root.val) {
        return false;
    }
    return validate(root.left) && validate(root.right);
}
```

上述实现有个致命问题，即对BST理解没到位，BST要求的是所有左边的节点都小于根、所有右边的节点都要大于根。上述实现只考虑了当前父子关系，没考虑全体。

实际上，应该这样思考：对于BST，每个子树有一个取值范围，(minVal, maxVal)，注意不是闭合的，即不能相等！  
每次递归遍历时，这个范围都会因为当前子树跟节点而变化。  
大体思路就是：  
- 判断当前节点root是否在(minVal, maxVal)范围内  
- 判断当前节点root的左子树是否在(minVal, root.val)范围内
- 判断当前节点root的右子树是否在(root.val, maxVal)范围内

感觉有关树的题目，其实往往代码写起来比较简单，因为往往需要用到递归，只是递归判断条件跟进题目变化。

### 思路2  
这个就是从网上看到的解法，利用中序遍历，参见https://discuss.leetcode.com/topic/4659/c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more  
二叉排序树的特点，中序遍历时所得到的结果刚好是一个有序数组，因此遍历过程中，只要比较前一个节点与当前节点、保证前一个节点小于当前节点即可。中序遍历找模板套一下即可实现。