package test.oj_24_swap_nodes;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;
import oj_solution.oj_24_swap_nodes_in_pairs.Solution;

public class Test_OJ_24 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n = new ListNode(2);
		n.next = null;
		head.next = n;
		
		Solution s = new Solution();
		s.swapPairs(head);
	}

}
