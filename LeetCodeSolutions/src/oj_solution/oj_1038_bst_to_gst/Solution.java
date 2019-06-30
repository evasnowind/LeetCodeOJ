package oj_1038_bst_to_gst;

/**
 * @author chenglong.yu@100credit.com
 * created on 2019/6/30
 */
public class Solution {

    int tmp = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (null != root) {
            if (null != root.right) {
                bstToGst(root.right);
            }

            root.val = root.val + tmp;
            tmp = root.val;

            if (null != root.left) {
                bstToGst(root.left);
            }
        }

        return root;
    }
}
