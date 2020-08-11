package solution.offer_problem.p55_binary_tree_max_depth;

/**
 * @author chenglong.yu
 * created on 2020/8/9
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}
