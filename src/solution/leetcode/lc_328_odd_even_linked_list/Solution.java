package solution.leetcode.lc_328_odd_even_linked_list;

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

    public ListNode oddEvenList2(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}

		ListNode oddTail = head, evenHead = head.next, evenTail = evenHead;
		boolean isOdd = true;
		while(null != evenTail.next) {
			ListNode node = evenTail.next;
			if (isOdd) {
                /*
                当前节点node是奇数节点.
                我们将奇数节点放到evenHead oddTail之间
                */

				oddTail.next = node;
				evenTail.next = node.next;
				node.next = evenHead;
				oddTail = node;
				/*
				需要注意一点，此处因为使用evenTail.next获取下一个节点。
				由于在这个if分支中已经拿出node、放到前面奇数链表中，
				后面的节点实际上已经挪动了一步，不用再执行
				evenTail = evenTail.next 这个步骤
				 */

				isOdd = false;
			} else {
				//当前节点是偶数

				isOdd = true;
				evenTail = evenTail.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		Solution s = new Solution();
		ListNode res = s.oddEvenList2(head);
		System.out.println(res);

	}
}
class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x){val = x;}
}
