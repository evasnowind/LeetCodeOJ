package solution.leetcode.lc_1110_del_node_ret_forest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2019/7/7
 */
public class Solution {

    private List<TreeNode> result = new ArrayList<>();
    private Set<Integer> to_delete_set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        to_delete_set = new HashSet<>();
        for (int val : to_delete) {
            to_delete_set.add(val);
        }

        delNodesRecursively(root, true);

        return result;
    }

    private TreeNode delNodesRecursively(TreeNode node, boolean isRoot) {
        if (node == null) {
            return null;
        }
        boolean deleted = to_delete_set.contains(node.val);
        if (isRoot && !deleted) {
            result.add(node);
        }
        node.left = delNodesRecursively(node.left, deleted);
        node.right = delNodesRecursively(node.right, deleted);
        return deleted ? null : node;
    }

}
