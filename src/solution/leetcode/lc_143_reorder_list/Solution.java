package solution.leetcode.lc_143_reorder_list;

public class Solution {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    /*
     * 基本思路：还是快/慢指针思路的运用，找到中间点，后半条链表进行逆序操作，
     * 			然后将两条链表拼在一起即可(此解法速度尚可，击败79.24%)
     * 	discuss上高票solution基本也是这思路，可以看这个：https://discuss.leetcode.com/topic/13869/java-solution-with-3-steps
     */
    public void reorderList(ListNode head) {
        if (null == head) return;
        ListNode slow = head, fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        fast = slow.next;
        slow.next = null;
        while (null != fast) {
            ListNode tmp = fast.next;
            fast.next = dummy.next;
            dummy.next = fast;
            fast = tmp;
        }
        slow = head;
        fast = dummy.next;
        while (null != slow && null != fast) {
            ListNode tmp = slow.next;
            slow.next = fast;
            slow = tmp;
            tmp = fast.next;
            fast.next = slow;
            fast = tmp;
        }
    }

    /*
    递归实现
    https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int len = 0;
        ListNode h = head;
        while(h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }
}
