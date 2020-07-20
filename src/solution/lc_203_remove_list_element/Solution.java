package solution.lc_203_remove_list_element;

public class Solution {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeElements(ListNode head, int val) {
        if (null == head) return null;
        ListNode start = new ListNode(0);
        ListNode lastNode, curNode;
        start.next = head;
        lastNode = start;
        curNode = head;
        while (null != curNode) {
            if (curNode.val == val) {
                lastNode.next = curNode.next;
                curNode = lastNode.next;
            } else {
                curNode = curNode.next;
                lastNode = lastNode.next;
            }
        }
        return start.next;
    }
}
