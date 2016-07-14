package oj_solution.oj_19_remove_n_node;

import oj_solution.oj_2_add_two_num.ListNode;

public class Solution {
	/*
	 * ʹ�ÿ�/��ָ�룬����ָ����Ϊn
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast, slow;
		ListNode start = new ListNode(0);
		start.next = head;
		fast = start;
		while(n>0){
			fast = fast.next;
			n--;
		}
		slow = start;
		while(null != fast.next){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
        return start.next;
    }
}
