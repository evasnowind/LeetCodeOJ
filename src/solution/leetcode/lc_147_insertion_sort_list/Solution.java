package solution.leetcode.lc_147_insertion_sort_list;

public class Solution {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    /*
     * 分析：插入排序算法的普通实现如下：
        void insertion_sort(int[] unsorted)
        {
            for (int i = 1; i < unsorted.Length; i++)
            {
                if (unsorted[i - 1] > unsorted[i])
                {
                    int temp = unsorted[i];
                    int j = i;
                    while (j > 0 && unsorted[j - 1] > temp)
                    {
                        unsorted[j] = unsorted[j - 1];
                        j--;
                    }
                    unsorted[j] = temp;
                }
            }
        }

     *
     * 仔细分析、多列几个测试用例，与上面算法不同的是，由于是链表，在移动时直接插入即可。
     * 需要考虑的用例如下：
     * [1]
     * [1,2]
     * [2,1]
     * [3,2,1]
     * [1,2,4]
     * [3,2,1,4]
     */
    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode dummy = new ListNode(0), curPos = head.next, nextPos, insertPos;
        dummy.next = head;
        dummy.next.next = null;
        while (null != curPos) {
            nextPos = curPos.next;
            curPos.next = null;
            insertPos = dummy;
            while (insertPos.next != null && insertPos.next.val <= curPos.val) {
                insertPos = insertPos.next;
            }
            curPos.next = insertPos.next;
            insertPos.next = curPos;
            curPos = nextPos;
        }
        return dummy.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        /*
        使用dummy节点，每次从dummy开始遍历。
        每次通过只比较pre.next cur.next，来保证一致能找到待交换节点的替换位置。

         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        while(pre.next != null) {
            ListNode cur = dummy;
            while(null != cur.next && cur.next.val < pre.next.val) {
                cur = cur.next;
            }
            if (cur == pre) {
                /*
                 如果cur== pre，说明pre节点比已经有序的所有节点都大，
                 就是要放到当前已经有序的部分的末尾，所以直接跳过该节点即可
                 */
                pre = pre.next;
                continue;
            } //else 说明当前cur.next节点在当前有序部分的中间位置，需要插入
            ListNode tmp = pre.next;
            pre.next = pre.next.next;
            tmp.next = cur.next;
            cur.next = tmp;
        }
        return dummy.next;
    }

    /**
     * 上面两种实现，每次插入时，都要遍历前边所有已有序的节点。
     * 可以通过保存已经有序的部分最后一个节点，减少一部分运算。
     * 如果大于末尾节点，直接跳过、不用再去找
     * @param head
     * @return
     */
    public ListNode insertionSortList3(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        /*
        使用dummy节点，每次从dummy开始遍历。
        每次通过只比较pre.next cur.next，来保证一致能找到待交换节点的替换位置。

         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNode = head;
        ListNode cur = head.next;
        while(null != cur) {
            if (cur.val >= lastNode.val) {
                lastNode = lastNode.next;
            } else {
                ListNode pre = dummy;
                /*
                由于已经知道cur要小于lastNode，必然在当前有序节点的中间位置，
                因此pre在遍历、找cur插入位置时不用判空
                 */
                while(pre.next.val <= cur.val) {
                    pre = pre.next;
                }
                lastNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastNode.next;
        }
        return dummy.next;
    }
}	
