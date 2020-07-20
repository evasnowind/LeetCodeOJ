package solution.lc_98_validate_binary_search_tree;

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
     * 思路：涉及到树结构，一般用递归比较方便，需要根据树的特点进行各种
     * 		判断。二叉搜索树（BST）特点题目已给出，注意BST并不是简单的
     * 		仅判断左右子节点与根节点就可以。discuss中有两种思路，
     * 		（1）保存一个取值区间，不断更新，如下
     * 		（2）中序遍历，参见https://discuss.leetcode.com/topic/4659/c-in-order-traversal-and-please-do-not-rely-on-buggy-int_max-int_min-solutions-any-more
     * 			这个思路很有意思，因为二叉排序树的特点，中序遍历时所得到的
     * 			结果刚好是一个有序数组，因此遍历过程中，只要比较前一个节点
     * 			与当前节点、保证前一个节点小于当前节点即可
     */
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (null == root) return true;
        if ((null != minNode && root.val <= minNode.val) || (null != maxNode && root.val >= maxNode.val)) {
            return false;
        }
        return validateBST(root.left, minNode, root) && validateBST(root.right, root, maxNode);
    }
}
