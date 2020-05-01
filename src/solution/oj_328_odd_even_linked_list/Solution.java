package solution.oj_328_odd_even_linked_list;

import oj_solution.oj_24_swap_nodes_in_pairs.ListNode;

public class Solution {

	/*
	 * 分析：简单思路是遍历链表过程中，将奇数节点放到链表a上，偶数节点放到
	 * 		链表b上，然后将a b串起来即可。但题目中要求尽量使用原地置换，那么
	 * 		采用同样的思路，分别记录在原链表上单数节点链表的尾节点otail、
	 * 		双数节点链表的头节点ehead、尾节点etail，逐步遍历、分别插入对应位置
	 * 		即可。代码如下。
	 * 另外，有更简单的思路，不用设标志位判断奇偶，参见
	 * https://discuss.leetcode.com/topic/34292/simple-o-n-time-o-1-space-java-solution
	 */
	public ListNode oddEvenList(ListNode head) {
		ListNode otail = head, etail, ehead;
		if(null == head || null == head.next){
			return head;
		}
		etail = head.next;
		ehead = etail;
		boolean isOdd = true;
		while(null != etail.next){
			ListNode node = etail.next;
			if(isOdd){
				otail.next = node;
				etail.next = node.next;
				node.next = ehead;
				otail = node;
				isOdd = false;
			} else {
				etail = etail.next;
				isOdd = true;
			}
		}
		return head;
    }
}
