package solution.leetcode.lc_701_insert_into_bst;

/**
 * @author chenglong.yu
 * created on 2020/9/30
 */
public class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        while(null != cur) {
            if (val < cur.val) {
                if (null == cur.left) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (null == cur.right) {
                    cur.right = new TreeNode(val);
                    break;
                } else {
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
