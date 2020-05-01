package solution.oj_101_symmetric_tree;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 思路：可以按层遍历，获得每层的数字放到一个数组中（节点为空则放null值，否则会有错），看该数组是否对称，所有层都对称则树对称
     * 		但这样代码写起来有些麻烦，还是用递归解树的问题比较方便，目前看到的比较简洁的写法参考
     * 		https://discuss.leetcode.com/topic/5941/recursive-and-non-recursive-solutions-in-java
     */
    public boolean isSymmetric(TreeNode root) {
        return null == root || isSymmetricSubTree(root.left, root.right);
    }

    private boolean isSymmetricSubTree(TreeNode left, TreeNode right) {
        if (null == left || null == right) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricSubTree(left.left, right.right) && isSymmetricSubTree(left.right, right.left);
    }
}
