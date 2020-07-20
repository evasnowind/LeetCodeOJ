package solution.lc_116_populating_next_right_pointer_in_each_node;

public class Solution {
	/*
	 * 分析：参考自https://discuss.leetcode.com/category/124/populating-next-right-pointers-in-each-node
	 * 很容易想到按层遍历，但按层遍历需要一个队列，队列最大需要叶子节点个数的空间（深度为d，则叶子个数2^d）
	 * 而discuss中的方法充分利用了输入数据的特殊性！
	 */
	public void connect(TreeLinkNode root) {
		TreeLinkNode startNode = root, curNode;
		while(null != startNode){
			curNode = startNode;
			while(null != curNode){
				if(null != curNode.left){
					curNode.left.next = curNode.right;
				}
				if(null != curNode.next && curNode.right != null){
					curNode.right.next = curNode.next.left;
				}
				curNode = curNode.next;
			}
			startNode = startNode.left;
		}
    }
}
