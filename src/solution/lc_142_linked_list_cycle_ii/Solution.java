package solution.lc_142_linked_list_cycle_ii;

public class Solution {
	/*
	 * 分析：非常经典的一道题，首先，判断链表是否有环用龟兔算法（Floyd Cycle Detection Algorithm），
	 * 		有相遇，说明有环，接下来需要计算相遇点，此处可以用如下思路：将其转换成两条链表求交点的问题，
	 * 		则可以先算两链表长度，同时记录下各自长度，长的先走m-n步，然后同时开始走，两个节点相同即为所求。
	 * 
	 * 进一步优化，可以有
	 * 找到相遇点可以用哈希表（进一步延伸的问题：如何判断两链表是否相交？——直接判断尾节点是否相等），但可以进行
	 * 如下分析：
	 * https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything
	 * http://www.cnblogs.com/BeyondAnyTime/archive/2012/07/06/2580026.html （这篇是中文，与discuss的思路一致）
	 * 最后即可得出：找到相遇点之后，slow从head走、fast从相遇点走，两者相遇即为环入口
	 * 算法复杂度分析：http://blog.csdn.net/javasus/article/details/50015687
	 * 
	 * 相关扩展问题：
	 * 	（1）判断两条链表是否相遇？
	 * 		hash表；
	 * 		判断尾节点；
	 * 		把第二个链表连接到第一个后面，判断得到的链表是否有环，有环则相交
	 * 	（2）求两个链表相交的第一个节点
	 * 		在判断是否相交的过程中要分别遍历两个链表，同时记录下各自长度，长的先走m-n步，然后同时开始走，两个节点相同即为所求
	 * 	（3）两条链表交叉，且有环
	 * 	（4）两条链表公用一个环
	 * 		（3）（4）见http://www.aichengxu.com/view/2575427
	 */
	public ListNode detectCycle(ListNode head) {
		if(null == head) return null;
		ListNode slow = head, fast = head;
		while(null != fast && null != fast.next){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		if(null == fast || null == fast.next){
			return null;
		}
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
    }
	
	class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x){val = x;}
	}
}
