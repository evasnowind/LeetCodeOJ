package solution.offer_problem.p06_reverse_print_linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/8/9
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[0];
        }

        ListNode pre = new ListNode(0);
        int cnt = 0;
        ListNode node = null;
        while(null != head) {
            cnt += 1;

            node = head.next;
            head.next = pre.next;
            pre.next = head;
            head = node;
        }

        int[] res = new int[cnt];
        cnt = 0;
        head = pre.next;
        while(null != head) {
            res[cnt] = head.val;
            head = head.next;
            cnt += 1;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
