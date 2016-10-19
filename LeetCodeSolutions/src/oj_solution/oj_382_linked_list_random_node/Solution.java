package oj_solution.oj_382_linked_list_random_node;

import java.util.Random;

import oj_solution.oj_2_add_two_num.ListNode;

public class Solution {
	
	/*
	 * 分析：最快的方式，所有节点全部放入hash表中，但题目中有提到可能节点数量
	 * 		非常大，因此此种方法不合适。那么可以采用如下方法，缺点是需要额外遍历
	 * 		一次链表、以计算长度。
	 * 
	 * TODO discuss上的不同解法有待进一步思考
	 */
	private ListNode listHead;
	private int listLen = 0;
	private Random random = new Random();
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
	    listHead = head;
	    while(null != head){
	    	head = head.next;
	    	listLen++;
	    }
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
		int idx =random.nextInt(listLen);
		ListNode curNode = listHead;
		while(idx > 0 && null != curNode){
			idx -=1;
			curNode = curNode.next;
		}
	    return curNode != null ? curNode.val:0;
	}
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(head);
	 * int param_1 = obj.getRandom();
	 */
}
