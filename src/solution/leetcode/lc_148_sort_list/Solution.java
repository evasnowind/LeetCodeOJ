package solution.leetcode.lc_148_sort_list;

/**
 * @author chenglong.yu
 * created on 2020/9/7
 */
public class Solution {


    /**
     * 结合链表相关题目，加上一个递归、归并流程而已，很简单，多练练即可。
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //递归结束条件
        if (null == head || head.next == null) {
            return head;
        }

        //找到中心点，断开
        ListNode fast = head.next, slow = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;
        //递归下降，指导每个链表只有1个元素
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        //从底向上开始合并操作，保证合并后的链表有序
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(null != left && null != right) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        //合并后，剩余的链表必然是有序的，直接接上即可。
        dummy.next = left != null ? left : right;
        //注意res指向的是链表哨兵节点
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

