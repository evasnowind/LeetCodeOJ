package oj_test.oj_82_remove_duplicates_from_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;
import oj_solution.oj_82_remove_duplicate_from_list_ii.Solution;

public class TestOJ82 {

	/*
	 * 备选测试用例
	 * 1 []
	 * 2 [1,1,2,2,3]
	 * 3 [1,1,1,1]
	 * 4 [1,2,3,4]
	 * 5 [1,2,3,4,4]
	 * 6 [1,1,2,2,3,3,4,4]
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(1);
		head.next = t1;
		t1.next = t2;
		t2.next = t3;
		
		Solution s = new Solution();
		s.deleteDuplicates(head);
	}

}
