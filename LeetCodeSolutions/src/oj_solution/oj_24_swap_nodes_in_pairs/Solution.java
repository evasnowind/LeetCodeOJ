package oj_solution.oj_24_swap_nodes_in_pairs;

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
	 * leetcode����һ�ֽⷨ���������ϳ����洢�ռ��Ҫ�󣬸õݹ��㷨
	 * �ǽ�ÿ2���ڵ���Ϊһ������Ԫ���ռ临�Ӷ�ΪO(n)
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
    	 * ʹ��dummyNode��Ϊͷ��㣬�������ô���
    	 * 1�����㴦�����н�㶼���Ե����������еĽڵ㽻�����������ͷ��㣬��һ�����Ľ�����Ҫ��������
    	 * 2��û��ͷ��㣬�������ҵ�����ͷ��������Ҫ����һ������������
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
