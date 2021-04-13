package solution.leetcode.lc_783_min_distance_between_bst_nodes;

/**
 * @author chenglong.yu
 * created on 2021/4/13
 */
public class Solution {

    private int minDiff = Integer.MAX_VALUE;
    /**
     * 输入的BST的值范围已规定大于等于0，因此
     * 此处默认值给一个-1来表示初始值没有问题。
     */
    private int pre = -1;

    public int minDiffInBST(TreeNode root) {
        inorderTraverseTree(root);
        return minDiff;
    }

    /**
     * 此处利用中序遍历BST能得到有序数组的特点，
     * 直接遍历整个二叉树、然后逐步比较邻近2个节点
     * 的差值，取最小的。
     *
     *
     * @param root
     */
    public void inorderTraverseTree(TreeNode root) {
        if (null == root) {
            return;
        }

        inorderTraverseTree(root.left);
        if (-1 == pre) {
            pre = root.val;
        } else {
            minDiff = Math.min(minDiff, root.val - pre);
            pre = root.val;
        }

        inorderTraverseTree(root.right);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

}
