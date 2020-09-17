package solution.leetcode.lc_543_diameter_of_binary_tree;

/**
 * @author chenglong.yu
 * created on 2020/9/17
 */
public class Solution {

    /**
     * 题目要求的路径，实际上可以理解寻找某个节点，使得：左子树+当前根节点+右子树  路径最长。
     * 而要找最长路径，实际上就是要求这棵子树的深度最大，但深度最大只能保证一条路径上，而题目要求
     * 实际上是左右两条加起来。可以利用深度优先遍历来查找。
     *
     * 更详细解释参考：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
     */
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        getTreeDepth(root);
        return res - 1;
    }

    private int getTreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        res = Math.max(left + right + 1, res);
        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
