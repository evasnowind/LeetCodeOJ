package solution.leetcode.lc_24_swap_nodes_in_pairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	
	/*
	 * 
	 * https://leetcode.com/problems/swap-nodes-in-pairs/
	 * 
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 
	 * 
	 * leetcode上另一种解法，但不符合常量存储空间的要求，该递归算法
	 * 是将每2个节点作为一个处理单元，空间复杂度为O(n)
	 public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
     }
	 */
    public ListNode swapPairs(ListNode head) {
    	if(null == head || null == head.next) return head;
    	ListNode dummyNode = new ListNode(0);
    	dummyNode.next = head;
    	/*
    	 * 使用dummyNode作为头结点，有两个用处：
    	 * 1、方便处理，所有结点都可以当做在链表中的节点交换，如果不加头结点，第一个结点的交换需要单独处理
    	 * 2、没有头结点，不方便找到链表头，还是需要额外一个变量来保存
    	 */
    	ListNode tmpNode = dummyNode;	
    	while(null != tmpNode.next && null != tmpNode.next.next) {
    		ListNode firstN = tmpNode.next;
    		ListNode secondN = tmpNode.next.next;    		
    		firstN.next = secondN.next;
    		secondN.next = firstN;
    		tmpNode.next = secondN;
    		tmpNode = firstN;
    	}
    
        return dummyNode.next;
    }
}
