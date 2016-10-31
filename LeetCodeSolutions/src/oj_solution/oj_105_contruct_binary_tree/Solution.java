package oj_solution.oj_105_contruct_binary_tree;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 分析：算法很直观，通过观察两个数组preorder inorder，即可发现，先根据preorder获取
	 * 		根，然后根据inorder获得左右子树，递归下去即可。其中，在inorder中找到根节点后，
	 * 		可以获知左子树、右子树的元素个数，据此在preorder中划分即可。
	 * 		需要注意的是边界值。
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(0, 0, preorder.length-1, preorder, inorder);
    }
	
	public TreeNode buildSubTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
		if(preStart > preorder.length-1 || inStart > inEnd){
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == preorder[preStart]){
				inIndex = i;
				break;
			}
		}
		root.left = buildSubTree(preStart+1, inStart, inIndex-1, preorder, inorder);
		root.right = buildSubTree(preStart + inIndex - inStart + 1, inIndex+1, inEnd, preorder, inorder);
		return root;
	}
}
