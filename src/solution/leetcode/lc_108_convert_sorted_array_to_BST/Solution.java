package solution.leetcode.lc_108_convert_sorted_array_to_BST;

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
	 * 思路：输入参数是一个有序数组，看到有序这俩字就应该联想是否可能用到二分的思想。
	 * 要求输出一个棵树，创建树的过程本身可以用递归实现。主要需要考虑创建什么样的树。
	 * 容易根据BST特点，联想到：取数组中位数作为根，必然满足“左右子树高度差不能超过1的二叉搜索树”这一要求。
	 * 接下来就按照递归模板写代码即可
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
