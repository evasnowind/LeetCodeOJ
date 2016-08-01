package oj_solution.oj_203_remove_list_element;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if(null == head) return null;
		ListNode start = new ListNode(0);
		ListNode lastNode, curNode;
		start.next = head;
		lastNode = start;
		curNode = head;
		while(null != curNode){
			if(curNode.val == val){
				lastNode.next = curNode.next;
				curNode = lastNode.next;
			}else {
				curNode = curNode.next;
				lastNode = lastNode.next;
			}
		}
		return start.next;
    }
}
