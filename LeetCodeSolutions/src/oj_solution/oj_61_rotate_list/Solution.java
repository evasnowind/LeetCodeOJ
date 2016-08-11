package oj_solution.oj_61_rotate_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	/*
	 * 思路：虽然leetcode上有类似题目rotate array，但两题思路完全不同。
	 * 本题实际上运用快、慢两个指针（解决链表题目时非常重要的一种思路！！！），类似题目如：找到链表中倒数第k节点
	 * 具体做法有如下两种：
	 * 1、先算长度的方式
	 * 	（1）遍历一遍，算出链表长度len，并保存尾节点
	 * 	（2）k = k % len, 走len - k步，断开、重连链表
	 * 2、不算长度
	 * 	思路与上面类似，区别在于保存一个头节点（一般用dummy即可），
	 * 	然后快、慢两个指针同时走（快节点先走k步），但需要考虑如下情况
	 * 	（1）k 小于链表长度：快节点走k步后，慢节点开始走，快节点到末尾即找到，断开、重连链表
	 * 	（2）k 大于链表长度：快节点走了n步（链表长度）后，下个节点为null，则从head继续开始走，
	 * 		直至走了k步，后续与（1）相同
	 * 
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(null == head) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow, fast = null;
		int len = 0;
		fast = dummy;
		while(fast.next != null){
			len += 1;
			fast = fast.next;
		}
		k = k % len;
		slow = dummy;
		for(int i = 0; i < (len-k); i++){
			slow = slow.next;
		}
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
        return dummy.next;
    }
}
