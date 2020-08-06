# 105 Construct Binary Tree from Preorder and Inorder Traversal  

Category	Difficulty	Likes	Dislikes
algorithms	Medium (46.84%)	2987	86

Tags
array | tree | depth-first-search

Companies
bloomberg

### Description  
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```
Return the following binary tree:  
```
    3
   / \
  9  20
    /  \
   15   7
```

# Thinking  

经典题目，数据结构课必学的一个算法。基本思路如下：

1. 先序遍历先找到根节点r
2. 在中序中找到r，中序左边即r的左子树，中序右边即为r的右子树
3. 根据中序左边，递归创建出左子树，接到r上，右子树同理
4. 重复上述过程给先序遍历中，注意**边界条件**，确定了r之后，在中序数组中，利用r左边的节点长度即可确定在先序数组中左子树根节点的位置

