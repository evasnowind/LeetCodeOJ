package oj_solution.oj_226_invert_binary_tree;

public class Solution {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public TreeNode invertTree(TreeNode root) {
		if(null == root) {
			return root;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.right = invertTree(left);
		root.left = invertTree(right);
        return root;
    }
}
