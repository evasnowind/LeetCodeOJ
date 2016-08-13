package oj_solution.oj_21_merge_two_sorted_list;

import oj_solution.oj_237_delete_node_in_linkedlist.ListNode;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
		if(l1 == null && l2 == null) return null;
        ListNode p1, p2, cur;
        p1 = l1;
        p2 = l2;
        cur = dummy;
    	while(null != p1 && null != p2){
    		if(p1.val <= p2.val){
    			cur.next = p1;
    			cur = p1;
    			p1 = p1.next;
    		} else {
    			cur.next = p2;
    			cur = p2;
    			p2 = p2.next;
    		}
    	}
    	if(null == p1){
    		cur.next = p2;
    	}
    	if(null == p2){
    		cur.next = p1;
    	}
       
        return dummy.next;
    }
}
