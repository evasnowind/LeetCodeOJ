package oj_solution.oj_19_remove_n_node;

import oj_solution.oj_2_add_two_num.ListNode;

public class Solution {
	/*
	 * 使用快/慢指针，两个指针间距为n
	 * 
	 * 参考：https://discuss.leetcode.com/topic/7031/simple-java-solution-in-one-pass
	 * 
	 * PS：注意快/慢指针的运用，这个技巧在有关链表的题目中经常被用到
	 * 
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
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
