package oj_solution.oj_257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 基本思路：DFS，遍历过程中记录每个节点的值，到叶子节点时将整条
	 * 			路径加入到结果集中。 
	 * 进一步优化：参考了 https://discuss.leetcode.com/topic/21474/accepted-java-simple-solution-in-8-lines
	 * 			直接以参数形式记录每条路径，避免重新创建一个数组保存的操作，提高了速度
	 * 加大难度：参见 oj 113 path sum ii
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if(null == root) return res;
		getPathString(root, res, "");
		return res;
    }
	
	private void getPathString(TreeNode root, List<String> res, String curPath){
		if(null == root) return;
		if(null == root.left && null == root.right){
			res.add(curPath + root.val);
		} else {
			getPathString(root.left, res, curPath + root.val + "->");
			getPathString(root.right, res, curPath + root.val + "->");
		}
	}
}
