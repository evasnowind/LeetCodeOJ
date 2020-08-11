package solution.lc_99_recovery_binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author chenglong.yu
 * created on 2020/8/8
 */
public class Solution {


    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null, y = null, preNode = null;

        TreeNode node = root;
        while(!stack.isEmpty() || null != node) {
            while(null != node) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (null != preNode && node.val < preNode.val) {
                y = node;
                if (null == x) {
                    x = preNode;
                } else {
                    break;
                }
            }

            preNode = node;
            node = node.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}