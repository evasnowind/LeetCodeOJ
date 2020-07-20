package solution.lc_257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

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
        public List<String> binaryTreePaths(TreeNode root) {
	        List<String> paths = new LinkedList<>();
	        if(root == null) return paths;
	        if(root.left == null && root.right == null){
	            paths.add(root.val+"");
	            return paths;
	        }
	         for (String path : binaryTreePaths(root.left)) {
	             paths.add(root.val + "->" + path);
	         }
	         for (String path : binaryTreePaths(root.right)) {
	             paths.add(root.val + "->" + path);
	         }
	         return paths;
    	}
    	*/
	/*
	 * 基本思路：DFS，遍历过程中记录每个节点的值，到叶子节点时将整条
	 * 			路径加入到结果集中。 
	 * 进一步优化：参考了 https://discuss.leetcode.com/topic/21474/accepted-java-simple-solution-in-8-lines
	 * 			直接以参数形式记录每条路径，避免重新创建一个数组保存的操作，提高了速度
	 * 
	 * 另一种解题思路：https://discuss.leetcode.com/topic/23047/clean-java-solution-accepted-without-any-helper-recursive-function
	 * 			代码参见上面注释部分，没有使用辅助递归函数，而是通过for循环递归，每次递归找到子树的所有路径，
	 * 			加上root.val+"->"之后就是当前树的所有路径，思路很有趣 
	 * 
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
