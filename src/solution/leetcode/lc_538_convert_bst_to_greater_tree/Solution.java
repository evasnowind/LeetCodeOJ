package solution.leetcode.lc_538_convert_bst_to_greater_tree;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/15
 */
public class Solution {

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {

        if (null != root) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    public TreeNode convertBST2(TreeNode root) {
        /*
        实际上下面这个程序是从先序遍历衍生出的解题方式，
        不过是从右子树向左开始先序
         */
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while(!stack.isEmpty() || null != cur) {
            while(null != cur) {
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;

            cur = cur.left;
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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}