package solution.leetcode.lc_968_binary_tree_cameras;

/**
 * @author chenglong.yu
 * created on 2020/9/22
 */
public class Solution {

    /**
     * 参见 https://leetcode-cn.com/problems/binary-tree-cameras/solution/jian-kong-er-cha-shu-by-leetcode-solution/
     * 这道题我暂时放弃，感觉官方题解写的很难理解，还不如这个 https://leetcode-cn.com/problems/binary-tree-cameras/solution/shou-hua-tu-jie-cong-di-gui-you-hua-dao-dong-tai-g/
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {

        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (null == root) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }

        int[] leftArr = dfs(root.left);
        int[] rightArr = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArr[2] + rightArr[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArr[0] + rightArr[1], rightArr[0] + leftArr[1]));
        array[2] = Math.min(array[0], leftArr[1] + rightArr[1]);
        return array;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


