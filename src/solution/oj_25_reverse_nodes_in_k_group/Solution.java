package solution.oj_25_reverse_nodes_in_k_group;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/5/16
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        //使用头节点，简化逆序操作
        ListNode listHead = new ListNode(0);
        listHead.next = head;
        ListNode curHead = listHead;
        ListNode curTail = listHead;

        while(null != curTail) {
            int curLen = 0;
            while(curTail != null && curLen < k) {
                curTail = curTail.next;
                curLen += 1;
            }
            //找到k个节点，若curTail已经为空，说明此时已经遍历完整个链表，结束即可
            if (null == curTail) {
                break;
            }

            //通过头插法，将从curHead到curTail 这k个节点原地逆序，然后移动curTail即可
            curHead = curTail;
        }

        //返回最终结果
        return curHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
