package oj_test.oj_101_symmetric_tree;

import oj_solution.oj_101_symmetric_tree.Solution;
import oj_solution.oj_226_invert_binary_tree.TreeNode;

public class TestOJ101 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode l1= new TreeNode(2);
		TreeNode r1= new TreeNode(2);
		root.left = l1;
		root.right = r1;
		
		TreeNode l2= new TreeNode(3);
		TreeNode r2= new TreeNode(4);
		l1.left = l2;
		l1.right = r2;
		
		TreeNode l3= new TreeNode(4);
		TreeNode r3= new TreeNode(3);
		r1.left = l3;
		r1.right = r3;
		
		Solution s = new Solution();
		s.isSymmetric(root);
	}

}
