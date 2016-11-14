package oj_solution.oj_104_maximum_depth_of_bt;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 分析：简单题，很容易想到如下的递归思路，此为DFS，但也可以用
	 * 		BFS的思路，按层遍历，每层递增1，遍历完即得结果，参见
	 * https://discuss.leetcode.com/topic/10317/my-code-of-c-depth-first-search-and-breadth-first-search
	 */
	public int maxDepth(TreeNode root) {
        if(null == root) {
        	return 0;
        } else {
        	int leftH = maxDepth(root.left);
        	int rightH = maxDepth(root.right);
        	return Math.max(leftH, rightH)+1;
        }
    }
}
