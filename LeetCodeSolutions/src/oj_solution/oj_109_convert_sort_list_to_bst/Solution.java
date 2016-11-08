package oj_solution.oj_109_convert_sort_list_to_bst;

import oj_solution.oj_226_invert_binary_tree.TreeNode;
import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {
	/*
	 * 参考https://discuss.leetcode.com/topic/35997/share-my-java-solution-1ms-very-short-and-concise
	 * 
	 * https://discuss.leetcode.com/topic/8141/share-my-o-1-space-and-o-n-time-java-code
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if(null == head) return null;
        return buildBST(head, null);
    }
	public TreeNode buildBST(ListNode head, ListNode tail){
		ListNode slow = head, fast = head;
		if(head == tail) return null;
		while(fast != tail && fast.next != tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = buildBST(head, slow);
		root.right = buildBST(slow.next, tail);
		return root;
	}
}
