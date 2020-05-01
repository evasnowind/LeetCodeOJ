package solution.oj_100_same_tree;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(null == p && null == q){
			return true;
		} else if(null != p && null != q
				&& isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right)
				&& p.val == q.val){
			return true;
		} else {
			return false;
		}
    }
}
