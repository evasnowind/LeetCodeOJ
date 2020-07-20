package solution.lc_141_linked_list_cycle;

public class Solution {

	class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x){val = x;}
	}

	/*
	 * 经典题目，采用快慢指针方案，即Floyd Cycle Detection Algorithm
	 * 
	 * 这一思路经常在有关链表的题目中出现
	 */
	public boolean hasCycle(ListNode head) {
		if(null == head) return false;
		ListNode slow = head, fast = head.next;
		boolean res = false;
		while(null != fast && null != fast.next){
			if(slow == fast){
				res = true;
				break;
			}
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
		return res;
    }
}
