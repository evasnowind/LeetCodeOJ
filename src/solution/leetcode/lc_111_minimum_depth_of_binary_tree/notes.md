# 111. Minimum Depth of Binary Tree

Category	Difficulty	Likes	Dislikes
algorithms	Easy (36.88%)	1551	709

Tags
tree | depth-first-search | breadth-first-search

Companies
Unknown

### Description  

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],
```
    3
   / \
  9  20
    /  \
   15   7
```

return its minimum depth = 2.

# Thinking  

很多人写出的代码都不符合 1,2 这个测试用例，是因为没搞清楚题意

题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点

题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果

另外这道题的关键是搞清楚递归结束条件

叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
- 当 root 节点左右孩子都为空时，返回 1
- 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
- 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值

上述引自：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/

## 思路1：递归解决

比较简单，参考上面阐述。

## 思路2：BFS  

BFS时，记录深度，当找到第一个叶子节点时，这个叶子就说明已经到了最短路径。
一定注意判断条件，是叶子节点，也就是*左右孩子不空*