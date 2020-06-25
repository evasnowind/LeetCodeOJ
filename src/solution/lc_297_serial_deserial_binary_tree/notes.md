# 297. Serialize and Deserialize Binary Tree

Category	Difficulty	Likes	Dislikes
algorithms	Hard (45.96%)	2859	141

Tags
tree | design

Companies
amazon | bloomberg | facebook | google | linkedin | microsoft | uber | yahoo

### Description  

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 
```
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
```


Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

# Thinking  

这道题目感觉有迷惑性，本质上其实就是要求遍历树、然后根据遍历结果反向恢复出一棵树。

第一步：遍历获取编码  
无非BFS/DFS两种。
用BFS按层遍历的思路不用递归，也比较快，因此可以参考leetcode 94的实现。直接按层遍历、输出一个数组（中间用一个间隔符，以便区分不同元素），至于每个元素如何编码，这个都是额外工作、怎样都好。
注意为了区分空节点与正常节点，遇到空节点需保存特殊字符。

第二步：逆向生成树  
反序列化过程，需要依据序列化过程所采用的算法。由于上面采用了按层遍历的思路、生成了一个数组，那么反序列化时，采用类似的思路，遍历数组，第1个元素是根，然后入队。由于数组中元素是按层遍历，元素实际上的第2个、第3个节点，是第1个元素的孩子节点；第4/5是第2的左右孩子；第6/7是第3的左右孩子；。。。
