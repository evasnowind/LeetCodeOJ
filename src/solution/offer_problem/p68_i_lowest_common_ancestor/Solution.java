package solution.offer_problem.p68_i_lowest_common_ancestor;

/**
 * @author chenglong.yu
 * created on 2020/10/10
 */
public class Solution {
    /*
        此题比较简单的地方在于，题目给出的树是BST，方便判断节点与树的关系。

        参考题解：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/

        递归实现：
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

        非递归实现如下：时间O(n)，空间O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        让p/q有序，可以简化下面循环中的判断，
         */
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }

        while(null != root) {
            if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                /*
                说明此时root的值在[p,q]中间。
                那么此时的root就是最近公共祖先节点。
                因为根据BST性质，此时两个节点已经分别在左右子树，
                若root再继续往下，会导致某个节点不是子节点。
                 */
                break;
            }
        }

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
