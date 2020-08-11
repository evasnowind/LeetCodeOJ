package solution.offer_problem.p27_mirror_tree;

/**
 * @author chenglong.yu
 * created on 2020/8/9
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        mirrorTree(left);
        mirrorTree(right);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
