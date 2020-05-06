# Description  
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following [1,2,2,null,3,null,3] is not:
```
    1
   / \
  2   2
   \   \
   3    3
```

Follow up: Solve it both recursively and iteratively.

# Thinking  
看到树，首先想到使用递归。
需要注意充分题目意思，要求判断的是树是否镜面对称，不是说两边相等，因此递归时需要判断：  
- 同一层的左节点、右节点  
- 左节点的左孩子与右节点的右孩子，左节点的右孩子与右节点的左孩子  

第一个根节点需要特殊处理，因为有空的情况。根节点的左右子树，则依据上述逻辑，逐层判断即可。