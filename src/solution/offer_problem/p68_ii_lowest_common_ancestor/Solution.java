package solution.offer_problem.p68_ii_lowest_common_ancestor;

/**
 * @author chenglong.yu
 * created on 2020/10/10
 */
public class Solution {
    /*
    此题麻烦的地方在于，题目给出的树不是BST，无法直接通过树中节点的值与p/q比较获知父子/祖先关系。
    但可以利用后续遍历时能自底向上找到p q，然后再逐层网上来比较。

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null == left && null == right) {
            /*
            说明该子树中不包含p q两个节点，返回null
             */
            return null;
        }
        if (null == left && null != right) {
            /*
            左子树没找到，右子树找到了将节点，此时有两种情况:
            1. p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）
            2. p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；

            然后通过递归的过程，传到上层方法调用，用于上层判断p q的情况
             */
            return right;
        }
        if (null != left && null == right) {
            /*
            与上面类似，此处分析略。
             */
            return left;
        }

        /*
        null != left && null != right
        说明p q在当前节点两边，root即为所求。
         */
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
