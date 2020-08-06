package solution.leetcode.lc_106_construct_bt_from_inorder_postorder;

import java.util.HashMap;

public class Solution {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 思路比较清晰，先看后序遍历的最后一个节点，此为根节点，然后在中序中找到根节点位置，在中序中根节点左边
	 * 即为左子树、右边即为右子树，递归这个过程即可
	 * 代码实现：参考了https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(null == inorder || null == postorder || inorder.length != postorder.length) return null;
		HashMap<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			idxMap.put(inorder[i], i);
		}
		return buildSubTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, idxMap);
    }
	
	public TreeNode buildSubTree(int[] inorder, int inStart, int inEnd, 
			int[] postorder, int postStart, int postEnd,HashMap<Integer, Integer> idxMap){
		if(inStart > inEnd || postStart > postEnd) return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int rootIdx = idxMap.get(postorder[postEnd]);
		TreeNode left = buildSubTree(inorder, inStart, rootIdx-1, postorder, postStart, postStart+rootIdx-inStart-1, idxMap);
		TreeNode right = buildSubTree(inorder, rootIdx+1, inEnd, postorder, postStart+rootIdx-inStart, postEnd-1, idxMap);
		root.left = left;
		root.right = right;
		return root;
	}
}
