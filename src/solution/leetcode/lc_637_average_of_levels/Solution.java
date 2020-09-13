package solution.leetcode.lc_637_average_of_levels;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/12
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            //由于节点中的值可能是Integer.MAX_VALUE,必须用long，避免计算时溢出
            long curSum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode cur = queue.poll();
                curSum += cur.val;
                if (null != cur.left) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }
            }
            if (curSum > Integer.MAX_VALUE) {
                res.add(-1D);
            } else {
                res.add(curSum * 1.0 / num);
            }

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


