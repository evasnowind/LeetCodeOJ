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



	private int countLevel(TreeNode root) {
		int level = 0;
		while(null != root) {
			level+=1;
			root = root.left;
		}
		return level;
	}

	public int countNodes2(TreeNode root) {
		if (null == root) {
			return 0;
		}

		int left = countLevel(root.left);
		int right = countLevel(root.right);
		if (left == right) {
            /*
            由于我们统计深度时，是利用完全二叉树性质，只遍历了左节点，
            那么对于右子树，可能出现只差一个叶子就是满二叉树、但深度仍与
            左子树相等的情况。
            因此，当left=right是，只能说明左子树一定是满二叉树，仍需要
            统计右子树。而左子树是满二叉树时，整个左子树节点个数是2^left-1。
            加上根节点，刚好就是2^left，剩下只需要递归统计右子树即可。
            */
			return countNodes2(root.right) + (1<<left);
		} else {
            /*
            当左右子树深度不等，那么说明倒数第一层没满、但倒数第二层肯定慢了。
            我们此时拿到的右子树就是满二叉树、且深度就是right，则右子树个数2^right-1，
            加上根，仍是2^right，再继续递归统计左子树的个数即可。
            */
			return countNodes2(root.left) + (1<<right);
		}
	}
}
