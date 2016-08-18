package oj_solution.oj_234_palindrome_linked_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	/*
	 * 思路：判断回文，首先想到的是类似OJ9 palindrome number的解法，即算出逆序后数/字符串，两者相互
	 * 		比较。但本题特殊之处在于要比对的是链表，而且要求O(1)空间，因此这里可以采用链表中常用的
	 * 		快/慢指针，找到链表中点，然后将后半个链表逆序（直接用O(1)空间、遍历一次逆序，比较简单）
	 * 		后与前半个链表进行比对。注意：链表长度为奇数或是偶数，中点处理不同，因此需要区别判断。
	 */
	public boolean isPalindrome(ListNode head) {
		if(null == head) return true;
		ListNode slow = head, fast = head, halfHead;
		while(null != fast && null != fast.next){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null){
			//奇数
			slow = slow.next;
		}
		halfHead = reverseList(slow);
		while(halfHead != null && head.val == halfHead.val){
			head = head.next;
			halfHead = halfHead.next;
		}
        return halfHead == null;
    }
	
	private ListNode reverseList(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		while(head != null){
			ListNode next = head.next;
			head.next = dummy.next;
			dummy.next = head;
			head = next;
		}
		return dummy.next;
	}
}
