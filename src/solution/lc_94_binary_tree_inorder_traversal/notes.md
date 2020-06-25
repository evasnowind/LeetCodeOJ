# 94 Binary Tree Inorder Traversal  

Binary Tree Inorder Traversal
Category	Difficulty	Likes	Dislikes
algorithms	Medium (61.72%)	2752	117


Tags
hash-table | stack | tree

Companies
microsoft

### Description  

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

Follow up: Recursive solution is trivial, could you do it iteratively?

# Thinking  

## 思路1：递归遍历  
思路很简单，不解释。  

## 思路2：非递归方式

非递归的方式，实际上就是自己创建一个栈、维护遍历状态，以便模拟递归调用。
