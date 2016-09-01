package oj_solution.oj_143_reorder_list;

import oj_solution.oj_237_delete_node_in_linkedlist.ListNode;

public class Solution {
	/*
	 * 基本思路：还是快/慢指针思路的运用，找到中间点，后半条链表进行逆序操作，
	 * 			然后将两条链表拼在一起即可(此解法速度尚可，击败79.24%)
	 * 	PS:得看看discuss，看是否可以进一步优化
	 */
	public void reorderList(ListNode head) {
		if(null == head) return;
        ListNode slow = head, fast = head;
        
        while(null != fast && null != fast.next){
        	slow = slow.next;
        	fast = fast.next;
        	fast = fast.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        fast = slow.next;
        slow.next = null;
        while(null !=fast){
        	ListNode tmp = fast.next;
        	fast.next = dummy.next;
        	dummy.next = fast;
        	fast = tmp;
        }
        slow = head;
        fast = dummy.next;
        while(null != slow && null != fast){
        	ListNode tmp = slow.next;
        	slow.next = fast;
        	slow =tmp;
        	tmp = fast.next;
        	fast.next = slow;
        	fast = tmp;
        }
    }
}
