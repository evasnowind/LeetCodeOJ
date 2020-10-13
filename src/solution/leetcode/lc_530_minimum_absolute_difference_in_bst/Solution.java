package solution.leetcode.lc_530_minimum_absolute_difference_in_bst;


/**
 * @author chenglong.yu
 * created on 2020/10/12
 */
public class Solution {
    int min = Integer.MAX_VALUE;

    int lastVal = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorderTraverse(root);
        return min;
    }

    private void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inorderTraverse(root.left);
        min = Math.min(Math.abs(lastVal - root.val), min);
        lastVal = root.val;
        inorderTraverse(root.right);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}

