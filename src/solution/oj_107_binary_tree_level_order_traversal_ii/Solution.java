package solution.oj_107_binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	 * 分析：经典的按层遍历，但将每行遍历结果逆序加到结果队列即可（实际是一个BFS）
	 * 下面的实现是非递归的BFS解题思路。
	 * 
	 * discuss中提供了另一种基于DFS的解题思路，
	 * 参考：https://discuss.leetcode.com/topic/1672/is-there-any-better-idea-than-doing-regular-level-order-traversal-and-reverse-the-result
	 * 后面这个链接则给出了相应的非递归实现 https://discuss.leetcode.com/topic/7651/my-dfs-and-bfs-java-solution/2
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if(null == root) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> oneLevel = new ArrayList<Integer>(); 
		while(0 != queue.size()){
			TreeNode node = queue.poll();
			if(null != node){
				oneLevel.add(node.val);
				if(null != node.left) {
					queue.offer(node.left);
				}
				if(null != node.right){
					queue.offer(node.right);
				}
			} else{
				res.add(0, oneLevel);
				oneLevel = new ArrayList<Integer>();
				if(0 == queue.size()) {
					break;
				} else{
					queue.offer(null);
				}
			}
		}
        return res;
    }
}
