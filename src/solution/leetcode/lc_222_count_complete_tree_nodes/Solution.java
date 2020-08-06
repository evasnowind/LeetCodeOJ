package solution.leetcode.lc_222_count_complete_tree_nodes;

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
	 * 分析：
	 * 	下面代码来自：https://discuss.leetcode.com/topic/15533/concise-java-solutions-o-log-n-2
	 * 	这个discuss解释的比较细，不过是英文，看着可能有点费劲，其实说起来很简单，
	 * 	完全二叉树必然包含着一棵满二叉树，设完全二叉树高度为h，则满二叉树的高度为h-1.
	 * 	而满二叉树的节点个数为等比数列，可以利用高度算出来。因此进行如下递归：
	 * 		计算左右子树高度lh rh
	 * 		lh == rh
	 * 			左子树是满二叉树，递归右子树
	 * 		lh != rh
	 * 			右子树是满二叉树，递归左子树
	 * 	参考资料：
	 * 	http://www.bubuko.com/infodetail-899496.html
	 * 	http://www.cnblogs.com/TinyBobo/p/4588175.html
	 * 	http://bookshadow.com/weblog/2015/06/06/leetcode-count-complete-tree-nodes/
	 */
	int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
}
