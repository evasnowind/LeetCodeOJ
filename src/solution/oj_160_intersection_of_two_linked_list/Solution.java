package solution.oj_160_intersection_of_two_linked_list;

import oj_solution.oj_237_delete_node_in_linkedlist.ListNode;

public class Solution {
	/*
	 * 基本思路：计算两个链表长度，分别设为longList shortList，两者长度差为k，然后
	 * 			先单独遍历longList，走k步，然后同时开始遍历longList shortList，
	 * 			若有完全相等的节点则为交叉点
	 * 优化思路：参考https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
	 * 			这个帖子中说的很细，我们的目的并不是为了计算两条链表的长度，而是为了
	 * 			确保同时遍历两条链表时能同时达到交叉点。为此，使用类似快慢指针的思路，
	 * 			第一次遍历，两条链表同时从head开始遍历，节点a遍历shortList到头时，
	 * 			b遍历longList剩余部分即为两者所差的k个节点，这样刚好，将a指向longList，
	 * 			继续遍历，直至b遍历完longList，此时a所在位置刚好是longList剩余部分与
	 * 			shortList长度一致的位置，此时将b指向shortList，开始第二次遍历，a与b相等
	 * 			则说明遇到了交叉点。下面即实现，实际上是用一个循环做了基本思路里的所有事情。
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(null == headA || null == headB) return null;
		ListNode a = headA,b = headB;
		while( a != b){
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
		return a;
    }
}
