package oj_test.oj_203_remove_element;

import oj_solution.oj_203_remove_list_element.Solution;
import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Test_OJ_203 {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = new ListNode(2);
		ListNode t1 = new ListNode(3);
		ListNode t2 = new ListNode(4);
		ListNode t3 = new ListNode(3);
		head.next = t1;
		t1.next = t2;
		t2.next = t3;
		
		s.removeElements(head, 3);
	}

}
