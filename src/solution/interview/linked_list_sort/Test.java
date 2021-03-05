package solution.interview.linked_list_sort;

/**
 * @author chenglong.yu
 * created on 2021/2/25
 */
public class Test {

    public static void main(String[] args) {


    }

    private ListNode reverse(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode cur = head;
        while(null != cur) {
            ListNode tmp = cur;
            cur = cur.next;

            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }

    private ListNode linkedsort(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        //找中点
        ListNode slow = head, fast = head;
        while(null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //分裂
        ListNode p1 = linkedsort(head);
        ListNode p2 = linkedsort(slow.next);

        //聚合
        ListNode res = new ListNode();
        ListNode cur = res;
        while(p1 != null || p2 != null) {
            if (p1 == null && p2 != null) {
                cur.next = p2;
                p2 = p2.next;
            } else if (p1 != null && p1 == null) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                if (p1.val > p2.val) {
                    cur.next = p2;
                    p2 = p2.next;
                } else {
                    cur.next = p1;
                    p1 = p1.next;
                }
            }
            cur = cur.next;
        }
        return res.next;
    }
}

class ListNode {
    int val;
    ListNode next;
}
