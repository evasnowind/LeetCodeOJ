package solution.offer_problem.p22_get_the_k_th_from_end;

/**
 * @author chenglong.yu
 * created on 2020/9/21
 */
public class Solution {

    /**
     * 示例
     * 1->2->3->4->5, 和 k = 2.
     * 返回4->5
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return head;
        }

        ListNode slow = head, fast = head;
        int cnt = k;
        while(null != fast && cnt > 0) {
            fast = fast.next;
            cnt--;
        }

        while(null != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
