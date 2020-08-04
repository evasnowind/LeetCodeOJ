package solution.lc_114_flattern_bt_to_linked_list;

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
	 * 分析：下面是一个直观的思路，但效率不高，discuss上给出了如下算法
	 * (参见https://discuss.leetcode.com/topic/3995/share-my-simple-non-recursive-solution-o-1-space-complexity)
void flatten(TreeNode *root) {
		TreeNode*now = root;
		while (now)
		{
			if(now->left)
			{
                //Find current node's prenode that links to current node's right subtree
				TreeNode* pre = now->left;
				while(pre->right)
				{
					pre = pre->right;
				}
				pre->right = now->right;
                //Use current node's left subtree to replace its right subtree(original right 
                //subtree is already linked by current node's prenode
				now->right = now->left;
				now->left = NULL;
			}
			now = now->right;
		}
    }
	 * 另外，非递归版本如下；https://discuss.leetcode.com/topic/11444/my-short-post-order-traversal-java-solution-for-share
	 * 
	 * 基本思路是：先找到左子树最右的叶子，这个叶子节点必然是当前root的右子树的父亲（因为是先序遍历），
	 * 			接上去之后，再继续将右子树第一个孩子节点（即原左子树第一个孩子）进行上述操作
	 * 
	 */
	public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        preorderTraverse(root, nodeList);
        for(int i = 1; i < nodeList.size(); i++){
        	nodeList.get(i-1).left = null;
        	nodeList.get(i-1).right = nodeList.get(i);
        }
    }
	
	private void preorderTraverse(TreeNode root, List<TreeNode> nodes){
		if(null == root){
			return;
		}
		nodes.add(root);
		preorderTraverse(root.left, nodes);
		preorderTraverse(root.right, nodes);
	}


	public void flatten2(TreeNode root) {
		while(null != root) {
			//左子树为 null，直接考虑下一个节点
			if (root.left == null) {
				root = root.right;
			} else {
				TreeNode pre = root.left;
				while(pre.right != null) {
					pre = pre.right;
				}
				//原来的右子树接到左子树的最右节点
				pre.right = root.right;
				//将左子树插入到右子树的地方
				root.right = root.left;
				root.left = null;
				//继续下一个节点
				root = root.right;
			}
		}
	}
}
