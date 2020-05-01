package solution.oj_100_same_tree;


public class Solution {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

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
