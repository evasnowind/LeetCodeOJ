package solution.offer_problem.p25_merge_sorted_linked_list;

/**
 * @author chenglong.yu
 * created on 2020/10/5
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        if (null == l1 && null == l2) {
            return null;
        }
        ListNode cur = dummy;
        while(null != l1 || null != l2) {
            if (null != l1 && null != l2) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            } else if (null == l1) {
                cur.next = l2;
                break;
            } else {
                cur.next = l1;
                break;
            }
        }

        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
