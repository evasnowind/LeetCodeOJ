package solution.oj_110_balanced_binary_tree;

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
     * 分析：很容易想到的思路是按照BBT的定义，递归算出根节点两个孩子的高度，
     * 		比较，如果是BBT，再看两个孩子节点是否为BBT，这个过程很明显会有
     * 		大量的重复计算，参见https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
     * 		top to down的解法，时间复杂度为O(N)
     * 		相反，down to top解法则利用深度优先搜索，从下往上判断，先判断
     * 		当前遍历的子树是否为BBT，如果是再判断父亲、祖父……，时间复杂度为O(N)
     *
     * 参见https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
     *
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getTreeHeight(root) != -1;
    }

    private int getTreeHeight(TreeNode root) {
        if (null == root) {//递归终止条件
            return 0;
        }
        int leftHeight = getTreeHeight(root.left);
        if (-1 == leftHeight) {//左子树已经不是BBT
            return -1;
        }
        int rightHeight = getTreeHeight(root.right);
        if (-1 == rightHeight) {//右子树已经不是BBT
            return -1;
        }
        if ((leftHeight - rightHeight) < -1 || (leftHeight - rightHeight) > 1) {
            return -1;//左右子树都是BBT，但当前节点不符合BBT条件
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
