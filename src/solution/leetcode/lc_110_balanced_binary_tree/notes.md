# 110. Balanced Binary Tree

Category	Difficulty	Likes	Dislikes
algorithms	Easy (42.87%)	2415	177

Tags
tree | depth-first-search

Companies
bloomberg

### Description  

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:
Given the following tree [3,9,20,null,null,15,7]:
```
    3
   / \
  9  20
    /  \
   15   7
```
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:
```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

Return false.

# Thinking  

本题思路很容易想到：算出每个子树的左子树、右子树高度，比较，判断是否符合平衡二叉树的定义。
但如果直接定一个计算树高度的函数、遍历时调用，明显有大量重复计算。那么，问题就在如何减少计算、尽量一次遍历就解决？

其实根源就在：我们在遍历过程中，一方面想保留树高度这个信息，另一方面又希望知道子树是否为平衡二叉树。
那么可以定义helper函数，使其返回值为int值，返回-1时表示不符合平衡二叉树定义，返回非负数则表示树的高度，则可以通过一次遍历、利用递归来解决问题。