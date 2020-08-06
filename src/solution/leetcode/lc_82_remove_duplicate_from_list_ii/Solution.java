package solution.leetcode.lc_82_remove_duplicate_from_list_ii;

public class Solution {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /*
     * 另一种思路：用递归思路：如下
     * https://discuss.leetcode.com/topic/5206/my-recursive-java-solution/2
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
    */
    /*
     * 基本思路：使用3个指针，一起往前遍历，分别记录相同元素起始前一节点、
     * 相同元素第一个节点、相同元素下一个节点，不断删除相同元素，如下
     * 注：下面代码还可以继续优化一下，没必要用3个指针
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node0, node1, node2;
        ListNode start = new ListNode(0);
        start.next = head;
        node0 = start;
        node1 = head;
        node2 = head.next;
        while (null != node2) {
            if (node1.val == node2.val) {
                while (node2.next != null && node1.val == node2.val) {
                    node2 = node2.next;
                }
                if (node1.val != node2.val) {
                    node0.next = node2;
                    node1 = node2;
                    node2 = node2.next;
                } else {
                    node0.next = null;
                    break;
                }
            } else {
                node0 = node0.next;
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return start.next;
    }
}
