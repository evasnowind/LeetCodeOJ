package solution.oj_113_path_sum_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class Solution {
	/*
	 * 算法：DFS的运用，遍历过程中记录当前路径中的每个数，然后在
	 * 		叶子节点时判断
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(null == root) return res;
		/*
		 * tmp分别尝试ArrayList、LinkedList，结果会发现使用LinkedList时
		 * 速度不如ArrayList，原因在于：在getPathSum遍历到叶子节点、删除
		 * 链表末尾节点时，使用了remove(index)的方式，这隐含着一个遍历操作。
		 * 
		 * 如果是在删除时直接调用remove(Object)则是从链表中通过改变指向删除节点，
		 * 是一个O(1)的操作，以后应该注意这一点。
		 */
		List<Integer> tmp = new ArrayList<Integer>();
		getPathSum(root,sum,res,tmp);
		return res;
    }
	
	private void getPathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp){
		if(null == root) return;
		if(null == root.left && null == root.right && sum == root.val){
			tmp.add(root.val);
			ArrayList<Integer> onePath = new ArrayList<Integer>(tmp);
			res.add(onePath);
			tmp.remove(tmp.size() - 1);
		} else {
			tmp.add(root.val);
			getPathSum(root.left, sum - root.val, res, tmp);
			getPathSum(root.right, sum - root.val, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
