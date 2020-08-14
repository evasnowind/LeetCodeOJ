package solution.offer_problem.p18_delete_node_in_linkedlist;

/**
 * @author chenglong.yu
 * created on 2020/8/13
 */
public class Solution {


    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while(null != cur.next) {
            if (cur.next.val == val) {
                ListNode node = cur.next;
                cur.next = node.next;
                node.next = null;
                node = null;
                break;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(-3);
        a.next = new ListNode(5);

        Solution s = new Solution();
        s.deleteNode(a, -3);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
