package solution.oj_102_binary_tree_level_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue.add(null);
            TreeNode tn = queue.remove();
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            while (null != tn) {
                levelList.add(tn.val);
                if (null != tn.left) queue.add(tn.left);
                if (null != tn.right) queue.add(tn.right);
                tn = queue.remove();
            }
            result.add(levelList);
        }
        return result;
    }
}