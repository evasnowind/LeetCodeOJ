package solution.leetcode.lc_111_minimum_depth_of_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {



	
	/*
	public int minDepth(TreeNode root) {
		return getTreeDepth(root, 0);
    }
	
	private int getTreeDepth(TreeNode node, int dep){
		if(null == node) {
			return dep;
		}
		int leftDepth = 0, rightDepth = 0;
		leftDepth = getTreeDepth(node.left, dep+1);
		rightDepth = getTreeDepth(node.right, dep+1);
		
		return leftDepth < rightDepth ? leftDepth:rightDepth;
	}
	*/
	
	/*
	 * 分析：一开始我写的算法如上所示，但算法里没有考虑有一个子节点为空的情况，
	 * 		若子节点为空，则取另一侧子树的高度，而我上面的实现则直接取最小值，空子树
	 * 		仍会算出一个值，导致最后可能会将空子树高度作为最小值，与题目不符。
	 * 
	 * 参考：https://discuss.leetcode.com/topic/8723/my-4-line-java-solution/2
	 */
	public int minDepth(TreeNode root) {
		/*
		很多人写出的代码都不符合 1,2 这个测试用例，是因为没搞清楚题意

题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点

题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果

另外这道题的关键是搞清楚递归结束条件

叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
当 root 节点左右孩子都为空时，返回 1
当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值

作者：reals
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		 */
		if(null == root) return 0;
		if(null == root.left) return minDepth(root.right)+1;
		if(null == root.right) return minDepth(root.left)+1;
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

    public int minDepth3(TreeNode root) {
		//https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
		if(root == null) return 0;
		int m1 = minDepth(root.left);
		int m2 = minDepth(root.right);
		//1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
		//2.如果都不为空，返回较小深度+1
		return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
	}

    public int minDepth2(TreeNode root) {
		if (null == root) {
			return 0;
		}
		if (null == root.left && null == root.right) {
			return 1;
		}

		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int curDepth = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();

			boolean findNull = false;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (null == node.left && null == node.right) {
					//此处注意需要找到叶子节点，才说明找到了最短路径
					findNull = true;
					break;
				}

				if (null != node.left) {
					queue.offer(node.left);
				}
				if (null != node.right) {
					queue.offer(node.right);
				}
			}

			if (findNull) {
				//说明已经找到叶子节点，发现了最短深度对应的路径
				break;
			}
			curDepth += 1;
		}

		return curDepth;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		s.minDepth2(root);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
