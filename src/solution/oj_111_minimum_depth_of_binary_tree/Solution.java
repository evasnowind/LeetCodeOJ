package solution.oj_111_minimum_depth_of_binary_tree;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	
	/*
	public int minDepth(TreeNode root) {
		return getTreeDepth(root, 0);
    }
	
	private int getTreeDepth(TreeNode node, int dep){
		if(null == node) {
			return dep;
		}
		int leftDepth = 0, rightDepth = 0;
		leftDepth = getTreeDepth(node.left, dep+1);
		rightDepth = getTreeDepth(node.right, dep+1);
		
		return leftDepth < rightDepth ? leftDepth:rightDepth;
	}
	*/
	
	/*
	 * 分析：一开始我写的算法如上所示，但算法里没有考虑有一个子节点为空的情况，
	 * 		若子节点为空，则取另一侧子树的高度，而我上面的实现则直接取最小值，空子树
	 * 		仍会算出一个值，导致最后可能会将空子树高度作为最小值，与题目不符。
	 * 
	 * 参考：https://discuss.leetcode.com/topic/8723/my-4-line-java-solution/2
	 */
	public int minDepth(TreeNode root) {
		if(null == root) return 0;
		if(null == root.left) return minDepth(root.right)+1;
		if(null == root.right) return minDepth(root.left)+1;
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
