# 109. Convert Sorted LinkedList To Binary Search Tree  


Category	Difficulty	Likes	Dislikes
algorithms	Medium (45.93%)	2153	87
Tags
linked-list | depth-first-search

Companies
zenefits

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 

Example 1:

```
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
```

Example 2:
```
Input: head = []
Output: []
```

Example 3:
```
Input: head = [0]
Output: [0]
```

Example 4:
```
Input: head = [1,3]
Output: [3,1]
```

Constraints:
```
The numner of nodes in head is in the range [0, 2 * 10^4].
-10^5 <= Node.val <= 10^5
```

# Thinking  

容易联想到利用有序链表中最中间的节点作为根、左右元素尽量一致，就可以保证满足高度平衡这一要求。

根据有序数组创建一棵高度平衡二叉树很容易，用分治、递归的方式很容易创建。
但是本题是链表，于是问题转化为：如何在链表中找到中位节点。
而链表中有一个常用技巧：快慢指针，刚好就是用于找中位节点的。于是，问题搞定。