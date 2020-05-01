package solution.oj_21_merge_two_sorted_list;

import solution.oj_2_add_two_num.ListNode;

public class Solution {

	static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x){val = x;}
	}


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (null == l1 && null == l2) {
			return null;
		}
		if (null != l1 && null == l2) {
			return l1;
		}
		if (null != l2 && null == l1) {
			return l2;
		}
		//all list is not null: use head node to simply the operation
		ListNode head = new ListNode(0);
		head.next = l1;
		ListNode curNode = head;
		while(l1 != null || l2 != null) {
			if (null == l1) {
				curNode.next = l2;
				break;
			}
			if (null == l2) {
				curNode.next = l1;
				break;
			}

			if (l1.val <= l2.val) {
				curNode.next = l1;
				curNode = curNode.next;
				l1 = l1.next;
			} else {
				curNode.next = l2;
				curNode = curNode.next;
				l2 = l2.next;
			}
		}

		return head.next;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(4);

		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);

		s.mergeTwoLists(node1, node2);

	}
//
//
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//		if(l1 == null && l2 == null) return null;
//        ListNode p1, p2, cur;
//        p1 = l1;
//        p2 = l2;
//        cur = dummy;
//    	while(null != p1 && null != p2){
//    		if(p1.val <= p2.val){
//    			cur.next = p1;
//    			cur = p1;
//    			p1 = p1.next;
//    		} else {
//    			cur.next = p2;
//    			cur = p2;
//    			p2 = p2.next;
//    		}
//    	}
//    	if(null == p1){
//    		cur.next = p2;
//    	}
//    	if(null == p2){
//    		cur.next = p1;
//    	}
//
//        return dummy.next;
//    }
}
