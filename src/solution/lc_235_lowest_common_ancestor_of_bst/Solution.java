package solution.lc_235_lowest_common_ancestor_of_bst;

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
	 * 
	 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
	 * 或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	 *  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也
	 *  分别为二叉排序树。
	 * 
	 * 二叉搜索树的性质： 中序遍历二叉排序树可得到一个关键字的有序序列，一个无序序列可以
	 * 				通过构造一棵二叉排序树变成一个有序序列，构造树的过程即为对无序序列
					行排序的过程。每次插入的新的结点都是二叉排序树上新的叶子结点，在进行
					插入操作时，不必移动其它结点，只需改动某个结点的指针，由空变为非空即可。
					搜索,插入,删除的复杂度等于树高，O(log(n)).
	 * 
	 * 
	 * 思路：可以利用BST的性质，即根节点比所有左孩子小、比所有右孩子大，对于LCA，必然会出现
	 * 		一个孩子在左、另一孩子在右的情况，据此从根节点往下查找即可。
	 * 注：用此算法找到的必然是题目要求的LCA，因为比这个结果更高的节点，必然是同时位于p q的
	 * 		同一侧（同时大于或小于p q），而比此结果更低的节点则不可能是p q的祖先
	 * 参考：https://discuss.leetcode.com/topic/18381/my-java-solution
	 * 		https://discuss.leetcode.com/topic/18387/3-lines-with-o-1-space-1-liners-alternatives
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(null == root) return null;
		while(root != null){
			if(root.val > p.val && root.val > q.val){
				root = root.left;
			} else if(root.val < p.val && root.val < q.val){
				root = root.right;
			} else {
				break;
			}
		}
        return root;
    }
}
