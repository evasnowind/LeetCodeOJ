package solution.interview.remove_duplicate_nodes;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode curNode = head, preNode = preHead;
        while (null != curNode) {
            if (set.contains(curNode.val)) {
                preNode.next = curNode.next;
                curNode = curNode.next;
            } else {
                set.add(curNode.val);
                preNode = curNode;
                curNode = curNode.next;
            }
        }

        return preHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}
