package solution.offer_problem.p55_ii_is_balanced_tree;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null ==root) {
            return true;
        }
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = helper(root.left);
        if (-1 == left) {
            return -1;
        }
        int right = helper(root.right);
        if (-1 == right) {
            return -1;
        }

        int diff = Math.abs(left - right);
        return diff <= 1 ? Math.max(left, right) + 1 : -1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
