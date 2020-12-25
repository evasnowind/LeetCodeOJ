package solution.leetcode.lc_103_binary_tree_zigzag_level_order;

import java.util.ArrayList;
import java.util.Deque;
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

    /*
     * 基本思路：按层遍历，每次按照层数的奇偶性将每层遍历后创建的数字队列重排序
     * 优化：直接在按层遍历过程中生成相应顺序的数字队列，需要逆序的队列在生成队列时
     * 		直接插在队列头部，保证生成后的队列满足题目要求
     *
     * 另一种思路：用递归做
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) {
            return result;
        }

        boolean isOdd = true;//奇数
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue.add(null);
            TreeNode tn = queue.remove();
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            while (null != tn) {
                if (isOdd) {
                    levelList.add(tn.val);
                } else {
                    levelList.add(0, tn.val);
                }
                if (null != tn.left) {
                    queue.add(tn.left);
                }
                if (null != tn.right) {
                    queue.add(tn.right);
                }
                tn = queue.remove();
            }
            isOdd = isOdd ? false : true;
            result.add(levelList);
        }
        return result;
    }



    /**
     * 本题还是按层遍历，只不过稍微加了点变化。
     * 按锯齿形，或者说按之字形按层遍历。
     * 不过是在遍历每层的时候，对当前层的前后顺序做了点小变换。
     * 那直接在拿到当前层时，判断一下是从左往右，还是从右往左即可。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        boolean flag = false;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                if (!flag) {
                    curLevel.add(node.val);
                } else {
                    curLevel.addFirst(node.val);
                }

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }

            flag = !flag;
            res.add(curLevel);
        }

        return res;
    }
}
