package solution.leetcode.lc_86_partition_list;

/**
 * @author chenglong.yu
 * created on 2021/1/3
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
    }

    public ListNode partition(ListNode head, int x) {

        ListNode bigHeader = new ListNode(), smallHeader = new ListNode();
        ListNode smallTail = smallHeader, bigTail = bigHeader;

        //1->4->3->2->5->2
        ListNode cur = head;
        ListNode tmp = null;
        while(null != cur) {
            tmp = cur.next;
            cur.next = null;

            if (cur.val < x) {
                smallTail.next = cur;
                smallTail = smallTail.next;
             } else {
                bigTail.next = cur;
                bigTail = bigTail.next;
            }

            cur = tmp;
        }
        smallTail.next = bigHeader.next;
        return smallHeader.next;
    }


}
