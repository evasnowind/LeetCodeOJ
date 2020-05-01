package solution.oj_145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 后序遍历的非递归实现是先/中/后序非递归中最难的
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (null == root) return res;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root, lastNode = null;
        while (null != curNode) {
            nodeStack.push(curNode);
            curNode = curNode.left;
        }
        while (!nodeStack.isEmpty()) {
            curNode = nodeStack.pop();
            if (null == curNode.right || curNode.right == lastNode) {
                res.add(curNode.val);
                lastNode = curNode;
            } else {
                nodeStack.push(curNode);
                curNode = curNode.right;
                while (null != curNode) {
                    nodeStack.push(curNode);
                    curNode = curNode.left;
                }
            }
        }
        return res;
    }
}
