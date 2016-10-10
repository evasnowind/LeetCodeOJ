package oj_solution.oj_141_linked_list_cycle;

import oj_solution.oj_237_delete_node_in_linkedlist.ListNode;

public class Solution {
	/*
	 * 经典题目，采用快慢指针方案，即Floyd Cycle Detection Algorithm
	 * 
	 * 这一思路经常在有关链表的题目中出现
	 */
	public boolean hasCycle(ListNode head) {
		if(null == head) return false;
		ListNode slow = head, fast = head.next;
		boolean res = false;
		while(null != fast && null != fast.next){
			if(slow == fast){
				res = true;
				break;
			}
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
		return res;
    }
}
