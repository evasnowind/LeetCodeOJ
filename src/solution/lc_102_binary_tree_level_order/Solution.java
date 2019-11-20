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


    public List<List<Integer>> levelOrder2(TreeNode root) {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int levelNum = queue.size();
            //为了避免自动扩容，直接手工指定容器大小
            List<Integer> curLevelList = new ArrayList<>((int)(levelNum / 0.75));
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                curLevelList.add(curNode.val);
                if (null != curNode.left) {
                    queue.offer(curNode.left);
                }
                if (null != curNode.right) {
                    queue.offer(curNode.right);
                }
            }
            res.add(curLevelList);
        }
        return res;
    }
}
