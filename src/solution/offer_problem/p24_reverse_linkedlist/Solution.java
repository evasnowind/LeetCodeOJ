package solution.offer_problem.p24_reverse_linkedlist;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode guardNode = new ListNode(0);
        guardNode.next = null;

        ListNode curNode = head, tmpNode;
        while(null != curNode) {
            tmpNode = curNode.next;
            curNode.next = guardNode.next;
            guardNode.next = curNode;
            curNode = tmpNode;
        }

        return guardNode.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}