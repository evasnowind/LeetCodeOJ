package solution.leetcode.lc_617_merge_two_binary_tree;

/**
 * @author chenglong.yu
 * created on 2020/5/6
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        TreeNode root = createSingleNode(t1, t2);
        buildTreeHelper(t1, t2, root);

        return root;
    }



    private TreeNode buildTreeHelper(TreeNode t1, TreeNode t2, TreeNode root) {

        TreeNode firstLeftNode = null, secondLeftNode = null;
        TreeNode firstRightNode = null, secondRightNode = null;
        if (null != t1) {
            firstLeftNode = t1.left;
            firstRightNode = t1.right;
        }
        if (null != t2) {
            secondLeftNode = t2.left;
            secondRightNode = t2.right;
        }
        root.left = createSingleNode(firstLeftNode, secondLeftNode);
        root.right = createSingleNode(firstRightNode, secondRightNode);

        buildTreeHelper(firstLeftNode, firstRightNode, root.left);
        buildTreeHelper(firstRightNode, secondRightNode, root.right);

        return root;
    }

    private TreeNode createSingleNode(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        int val = 0;
        if (null != t1) {
            val += t1.val;
        }
        if (null != t2) {
            val += t2.val;
        }
        TreeNode node = new TreeNode(val);
        return node;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }

        TreeNode root = createSingleNode(t1, t2);
        helper(t1, t2, root);

        return root;
    }

    private void helper(TreeNode t1, TreeNode t2, TreeNode root) {
        //递归结束条件
        if (null == t1 && null == t2) {
            return;
        }

        TreeNode left1 = null, right1 = null, left2 = null, right2 = null;
        if (null != t1) {
            left1 = t1.left;
            right1 = t1.right;
        }
        if (null != t2) {
            left2 = t2.left;
            right2 = t2.right;
        }
        //处理当前节点
        root.left = createSingleNode(left1, left2);
        root.right = createSingleNode(right1, right2);

        //递归下降，获得子树节点
        helper(left1, left2, root.left);
        helper(right1, right2, root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
