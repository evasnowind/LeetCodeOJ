package solution.lc_92_reverse_linked_list;

public class Solution {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /*
     * 见：https://discuss.leetcode.com/topic/8976/simple-java-solution-with-clear-explanation
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }
    */
    /*
     * 思路：遍历过程中用多个指针（优化后见上面代码）
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head) return null;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode preNode, curNode, hNode, tNode, nextNode;
        preNode = start;
        curNode = head;
        hNode = new ListNode(0);
        tNode = null;
        int cnt = 1;
        while (cnt < m) {
            preNode = preNode.next;
            curNode = curNode.next;
            cnt += 1;
        }
        while (cnt <= n) {
            nextNode = curNode.next;
            if (null != tNode) {
                curNode.next = hNode.next;
                hNode.next = curNode;
            } else {
                tNode = curNode;
                hNode.next = tNode;
            }
            cnt += 1;
            curNode = nextNode;
        }
        tNode.next = curNode;
        preNode.next = hNode.next;
        return start.next;
    }
}
