package solution.lc_94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/5/8
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (null == root) {
            return result;
        }

        getInorderTraversalListRecursively(root, result);

        return result;
    }

    private void getInorderTraversalListRecursively(TreeNode root, List<Integer> list) {
        if (null != root) {
            getInorderTraversalListRecursively(root.left, list);
            list.add(root.val);
            getInorderTraversalListRecursively(root.right, list);
        }
    }



    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode curNode = root;
        while (null != curNode || !stack.isEmpty()) {
            while(null != curNode) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            res.add(curNode.val);
            curNode = curNode.right;
        }

        return res;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
