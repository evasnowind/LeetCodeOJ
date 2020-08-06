package solution.leetcode.lc_95_unique_binary_search_tress_ii;

import java.util.ArrayList;
import java.util.List;

/**
@author chenglong.yu
created on 2020/7/21
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (0 == n) {
            return res;
        }
        return createSubTree(1, n);
    }

    private List<TreeNode> createSubTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            res.add(tree);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeList = createSubTree(start, i - 1);
            List<TreeNode> rightTreeList = createSubTree(i + 1, end);
            for (TreeNode left : leftTreeList) {
                for (TreeNode right : rightTreeList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
