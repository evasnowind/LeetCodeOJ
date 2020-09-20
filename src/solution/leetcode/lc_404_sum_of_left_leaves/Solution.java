package solution.leetcode.lc_404_sum_of_left_leaves;


import java.util.ArrayList;
import java.util.List;

public class Solution {


	/*
	 * 分析：很简单的一道题目，其实就是树的遍历过程，下面的代码是我一开始想到的，没做
	 * 任何优化，代码有些多但容易理解：遍历，如果遇到左叶子则记录下来，最后遍历队列算出结果。
	 * 实际可以不用辅助方法，直接递归sumOfLeftLeaves就能求解，参考
	 * https://discuss.leetcode.com/topic/60403/java-iterative-and-recursive-solutions
	 * 
	 * 由于是树的遍历，因此也能用BFS（其实就是按层遍历的过程中判断是否为左叶子）。
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if(null == root) return 0;
		List<Integer> leaves = new ArrayList<Integer>();
		traverseTree(root.left, true, leaves);
		traverseTree(root.right, false, leaves);
		
		int res = 0;
		for(Integer n:leaves){
			res += n;
		}
		return res;
    }
	
	public void traverseTree(TreeNode root,boolean isLeft, List<Integer> leaves){
		if(null == root){
			return;
		}
		if(null == root.left && null == root.right
				&& isLeft){
			leaves.add(root.val);
			return;
		}
		traverseTree(root.left, true, leaves);
		traverseTree(root.right, false, leaves);
	}
	
	public int sumOfLeftLeaves2(TreeNode root) {
		if (null == root) {
			return 0;
		}

		int sum = 0;
		if (null != root.left && null == root.left.left && null == root.left.right) {
			sum += root.left.val;
		}

		if (null != root.left) {
			sum += sumOfLeftLeaves2(root.left);
		}
		if (null != root.right) {
			sum += sumOfLeftLeaves2(root.right);
		}

		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		TreeNode right = new TreeNode(20);
		right.left = new TreeNode(15);
		right.right = new TreeNode(7);

		root.right = right;

		Solution s = new Solution();
		int sum = s.sumOfLeftLeaves2(root);
		System.out.println(sum);
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}