package solution.leetcode.lc_124_binary_tree_max_path_sum;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author chenglong.yu
 * created on 2020/10/22
 */
public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getNodeMaxSum(root);
        return maxSum;
    }


    /**
     * 目标问题是要路径和，首先考虑在树的情况下，路径有
     * 哪几种情况，假定当前树的根节点为root：
     * 1、root+左子树+右子树
     * 2、root+左子树+root的父亲/祖先
     * 3、root+右子树+root的父亲/祖先
     *
     * 只要将3种情况都遍历到、取其中最大的即可。
     * 情况1实际上就是不用考虑父亲/祖先，假定自己这棵树+左右子树就有最值。
     * 题目刚开始的输入就属于这种情况。
     *
     * 既然是有关树的题目，很容易想到用递归来求解。由于需要
     * 拿到左、右子树的值，才能计算当前root的值，因此可以采用后续遍历
     * 来递归处理。
     *
     * 当然，在计算过程中需要过滤掉负值，若发现负值只加0即可。
     *
     * @param root
     * @return
     */
    private int getNodeMaxSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        /*
        此处实际上利用了后续遍历，来保证递归过程中当前root能看到左右子树的值。
         */
        int leftVal = getNodeMaxSum(root.left);
        int rightVal = getNodeMaxSum(root.right);
        /*
        lmr记录是不考虑当前root的父节点、仅考虑当前树、左右子树
        的情况下（比如初始输入的树就是这样），计算最大的路径值，
        此种情况必然包含root的值，而左右子树
        只有大于0才能使得路径值更大、才加入进来，所以加入了与0的比较。
         */
        int lmr = root.val + Math.max(leftVal, 0) + Math.max(rightVal, 0);
        /*
         retVal将作为返回值，传递给上层递归。此处所考虑的是上层父亲节点必然在
         路径内的情况，那么此时当前root的左右子树只可能有一条包含在路径中，
         选取最大的即可。
         */
        int retVal = root.val + Math.max(Math.max(leftVal, rightVal), 0);
        maxSum = Math.max(maxSum, Math.max(lmr, retVal));
        return retVal;
    }
}

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

