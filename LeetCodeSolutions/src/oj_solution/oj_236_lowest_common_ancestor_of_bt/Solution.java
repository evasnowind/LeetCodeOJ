package oj_solution.oj_236_lowest_common_ancestor_of_bt;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 分析：可以采用广度优先搜索，生成先辈子图（可以用哈希表存储，保存每个节点的父亲节点是谁），
	 * 然后用这个先辈子图分别生成两个节点的祖先链表，然后就转换成两条链表相交、求交点这一问题
	 * 
	 * leetcode解法：http://articles.leetcode.com/lowest-common-ancestor-of-a-binary-tree-part-i/
	 * https://discuss.leetcode.com/topic/18566/my-java-solution-which-is-easy-to-understand
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
