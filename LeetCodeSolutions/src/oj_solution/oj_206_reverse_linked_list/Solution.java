package oj_solution.oj_206_reverse_linked_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	/*
	 * 思路基本两种：递归或是遍历一次直接逆序
	 * 参见https://discuss.leetcode.com/topic/13268/in-place-iterative-and-recursive-java-solution
	 */
	public ListNode reverseList(ListNode head) {
		if(null == head) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		ListNode curNode, nextNode;
		curNode = head;
		while(null != curNode){
			nextNode = curNode.next;
			curNode.next = dummy.next;
			dummy.next = curNode;
			curNode = nextNode;
		}
        return dummy.next;
    }
}
