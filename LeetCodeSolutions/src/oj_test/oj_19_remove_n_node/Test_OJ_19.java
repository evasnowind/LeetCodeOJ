package oj_test.oj_19_remove_n_node;

import oj_solution.oj_19_remove_n_node.Solution;
import oj_solution.oj_2_add_two_num.ListNode;

public class Test_OJ_19 {

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node = new ListNode(3);
		head.next = node;
		
		Solution s = new Solution();
		ListNode result = s.removeNthFromEnd(head, 1);
	}

}
