package solution.lc_2_add_two_num;

public class AddTwoSum {

	
	/*
	 * 
	 * 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


	 * 
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode rp = null;
		ListNode tnode = null;
		ListNode result = new ListNode(0);
		rp = result;
		int val = 0;
		
		while(null != p1 || null != p2) {
			if(null != p1) {
				val = val + p1.val;
				p1 = p1.next;
			}
			
			if(null != p2) {
				val = val + p2.val;
				p2 = p2.next;
			}
			
			tnode = new ListNode(val % 10);
			rp.next = tnode;
			rp = tnode;
			
			val = val / 10;
		}
		
		if(val != 0) {
			tnode = new ListNode(val);
			rp.next = tnode;
			rp = tnode;
		}
		
		result = result.next;
		
        return result;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode p1 = l1;
		ListNode tmp = new ListNode(4);
		p1.next = tmp;
		p1 = p1.next;
		tmp = new ListNode(3);
		p1.next = tmp;
		p1 = p1.next;
		
		p1 = l2;
		tmp = new ListNode(6);
		p1.next = tmp;
		p1 = p1.next;
		tmp = new ListNode(4);
		p1.next = tmp;
		p1 = p1.next;
		
//		ListNode l1 = new ListNode(5);
//		ListNode l2 = new ListNode(5);
		
		ListNode result = addTwoNumbers(l1, l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
