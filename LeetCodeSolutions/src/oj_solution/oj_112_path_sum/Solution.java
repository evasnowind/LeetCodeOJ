package oj_solution.oj_112_path_sum;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	public boolean hasPathSum(TreeNode root, int sum) {
		if(null == root) return false;
		boolean result = false;
		if(null == root.left && null == root.right){
			if(sum == root.val){
				return true;
			}else {
				return false;
			}
		}else {
			if(null != root.left){
				result = hasPathSum(root.left, sum - root.val);
			}
			if(!result && null != root.right){
				result = hasPathSum(root.right, sum - root.val);
			}
		}
        return result;
    }
	*/
	/*
	 * 先序遍历，不用多讨论，上面注释的代码是一开始写的版本，但参考discuss后发现还能继续优化，
	 * 如下面所示。
	 * 要更快得到结果，则可以用先序遍历的非递归写法
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(null == root) return false;
		if(null == root.left && null == root.right && sum == root.val){
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
