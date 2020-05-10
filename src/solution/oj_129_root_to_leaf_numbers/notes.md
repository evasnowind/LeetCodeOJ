# Description  

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:  

```
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```

Example 2:  
```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

# Thinking  

## 思路1：暴力解法  
此类题最容易做，因为涉及到树的题目，一般可以套用各种遍历的框架。

本次实际上就是先序遍历到每个节点，然后获取一个数字。保存起来，然后再继续遍历，直到所有叶子都遍历完成，将结果相加即可。

## 思路2：进一步优化  
用递归处理树，这个本身是很正常的思路，在思路1基础上，可以进一步优化：  
- 优化1:将递归转为非递归：这个会增加代码量，但也是很常见的代码，直接套模板，可以加快一定执行时间
- 优化2:仍然保持递归结构，到叶子节点后，不用保存、直接在整个遍历过程中，就将节点的值累加起来、到叶子节点时直接返回。递归计算每棵子树的sum值，根节点的左右子树的和即为结果。  

优化1的思路是沿着思路1继续往下走，走的是深度优先遍历的思路；

优化2的实现方式与思路1不完全一样，是按照分治的思路求解：
- 从树的根节点到当前子树根节点的值（所有祖先到当前节点所形成的数），所生成的整数，加上当前节点左右子树的值。
- 最底层的子树就是叶子节点。在叶子节点计算出该路径的值，然后通过返回值的方式，将当前节点的结果返回给上层节点；

本文参考了https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/ 代码实现，并对该题解简单写了下个人理解。

```java
public int sumNumbers(TreeNode root) {
    return helper(root, 0);
}

private int helper(TreeNode root, int ancestorVal) {
    if (null == root) {
        return 0;
    }
    int tmp = ancestorVal * 10 + root.val;
    if (null == root.left && null == root.right) {
        return tmp;
    }
    return helper(root.left, tmp) + helper(root.right, tmp);
}
```
