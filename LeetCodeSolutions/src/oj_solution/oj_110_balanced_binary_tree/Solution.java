package oj_solution.oj_110_balanced_binary_tree;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 分析：很容易想到的思路是，算出每个节点的高度，然后判断其父亲是否是BBT，
	 * 		如果是，再算出父亲的高度，看祖父是否是BBT，……
	 */
	public boolean isBalanced(TreeNode root) {
		if(root==null){
	        return true;
	    }
        return getTreeHeight(root) != -1;
    }
	
	private int getTreeHeight(TreeNode root){
		if(null == root){//递归终止条件
			return 0;
		}
		int leftHeight = getTreeHeight(root.left);
		if(-1 == leftHeight){//左子树已经不是BBT
			return -1;
		}
		int rightHeight = getTreeHeight(root.right);
		if(-1 == rightHeight){//右子树已经不是BBT
			return -1;
		}
		if((leftHeight - rightHeight) < -1 || (leftHeight - rightHeight) > 1){
			return -1;//左右子树都是BBT，但当前节点不符合BBT条件
		}
		return Math.max(leftHeight, rightHeight)+1;
	}
}
