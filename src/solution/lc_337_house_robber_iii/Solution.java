package solution.lc_337_house_robber_iii;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/8/5
 */
public class Solution {

    public int rob(TreeNode root) {

        if (null == root) {
            return 0;
        }

        Map<TreeNode, Integer> memo = new HashMap<>();

        return helper(root, memo);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> memo) {
        if (null == root) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int val = root.val;
        if (null != root.left) {
            val = val + helper(root.left.left, memo) + helper(root.left.right, memo);
        }
        if (null != root.right) {
            val = val + helper(root.right.left, memo) + helper(root.right.right, memo);
        }
        int res = Math.max(val, helper(root.left, memo) + helper(root.right, memo));
        memo.put(root, res);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
