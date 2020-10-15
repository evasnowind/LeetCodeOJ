package solution.leetcode.lc_116_populating_next_right_pointer_in_each_node;

public class Solution {
	/*
	 * 分析：参考自https://discuss.leetcode.com/category/124/populating-next-right-pointers-in-each-node
	 * 很容易想到按层遍历，但按层遍历需要一个队列，队列最大需要叶子节点个数的空间（深度为d，则叶子个数2^d）
	 * 而discuss中的方法充分利用了输入数据的特殊性！
	 *
	 *
	 * 思路1：按层遍历，需要额外一个队列，时间、空间均为O(N)
	 * 思路2：充分利用完全二叉树的特性，父亲必然有两个孩子，并且每个节点有指向同级下一个节点的指针next。
	 * 那么可以利用next指针找到下一个按层遍历的目标。
	 */
	public void connect(TreeLinkNode root) {
		TreeLinkNode startNode = root, curNode;
		while(null != startNode){
			curNode = startNode;
			while(null != curNode){
				//同一个根节点下的左右孩子，将左孩子指向右孩子
				if(null != curNode.left){
					curNode.left.next = curNode.right;
				}
				//根节点右孩子指向同层下一个节点的左孩子
				if(null != curNode.next && curNode.right != null){
					curNode.right.next = curNode.next.left;
				}
				//指向同层下一个节点
				curNode = curNode.next;
			}
			//进入下一层，继续遍历
			startNode = startNode.left;
		}
    }
}
