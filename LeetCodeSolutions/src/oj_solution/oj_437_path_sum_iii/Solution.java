package oj_solution.oj_437_path_sum_iii;

import java.util.Stack;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	
	
	/*
	 * 分析：下面算法思路如下：深度遍历，累加这条路径从根节点到当前节点的和，判断
	 * 是否与sum相等，然后再从根节点开始，不断减少这条路径上的节点个数，看是否子
	 * 路径也与sum相等，以此保证不重复、不漏掉。
	 * 
	 * 参考：http://www.cnblogs.com/grandyang/p/6007336.html [LeetCode] Path Sum III 二叉树的路径和之三
	 * 
	 */
	int res = 0;
	
	public int pathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		helper(root, 0, sum, stack);
		return res;
    }
	
	public void helper(TreeNode root, int cur, int sum, Stack<TreeNode> stack){
		if(null == root){
			return;
		}
		stack.push(root);
		cur += root.val;
		if(sum == cur){
			res +=1;
		}
		int tmp = cur;
		for(int i = 0; i < stack.size() - 1; i++){
			tmp -= stack.get(i).val;
			if(tmp == sum){
				res += 1;
			}
		}
		helper(root.left, cur, sum, stack);
		helper(root.right, cur, sum, stack);
		stack.pop();
	}
	
	/*
	int pathSum(TreeNode* root, int sum) {
        if (!root) return 0;
        return sumUp(root, 0, sum) + pathSum(root->left, sum) + pathSum(root->right, sum);
    }
    int sumUp(TreeNode* node, int pre, int& sum) {
        if (!node) return 0;
        int cur = pre + node->val;
        return (cur == sum) + sumUp(node->left, cur, sum) + sumUp(node->right, cur, sum);
    }
    */
}
