package solution.lc_700_Search_In_BST;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/6/25
 */
public class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return root;
        }

        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (null == root) {
            return root;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode curNode = root;
        while(null != curNode && curNode.val != val) {
            if (val < root.val) {
                curNode = root.left;
            } else if (val > root.val) {
                curNode = root.right;
            }
        }
        return curNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
