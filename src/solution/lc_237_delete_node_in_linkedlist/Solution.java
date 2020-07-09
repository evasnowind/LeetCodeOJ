package solution.lc_237_delete_node_in_linkedlist;

public class Solution {
	/*
	 * 题目已说明node不会是尾节点，因此不用考虑node为空或是单节点情况
	 * 一般思路：将后面一个节点拷贝过来，删除后面那个节点
	 */
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){val = x;}
}