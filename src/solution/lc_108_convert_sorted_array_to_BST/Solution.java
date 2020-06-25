package solution.oj_108_convert_sorted_array_to_BST;

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
	 * 解析：首先得明确题目要求 height balanced BST，详细定义可以参见下面帖子
	 * 		https://discuss.leetcode.com/topic/718/the-definition-of-height-balanced-bst
	 * 		基本就是左右子树高度差不能超过1的二叉搜索树（参见平衡二叉树定义）。
	 * 思路：输入参数是一个有序数组，
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if(null == nums) return null;
		return createBST(nums, 0, nums.length-1);
    }
	private TreeNode createBST(int[] nums, int low, int high){
		if(low > high){
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createBST(nums, low, mid-1);
		root.right = createBST(nums, mid+1, high);
		return root;
	}
}
