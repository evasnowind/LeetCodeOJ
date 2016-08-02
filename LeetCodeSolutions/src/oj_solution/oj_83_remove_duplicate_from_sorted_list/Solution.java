package oj_solution.oj_83_remove_duplicate_from_sorted_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	/*
	 * 另一种思路：用递归
	 * https://discuss.leetcode.com/topic/14775/3-line-java-recursive-solution
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
	}
	*/
	/*
	 * 简单到不能再简单的题目，链表中使用两个指针的思路很有用，多个算法题中会用到
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode node1, node2;
		node1 = head;
		node2 = head.next;
		while(null != node2){
			if(node1.val == node2.val){
				node1.next = node2.next;
				node2 = node2.next;
			} else {
				node1 = node1.next;
				node2 = node2.next;
			}
		}
        return head;
    }
}
