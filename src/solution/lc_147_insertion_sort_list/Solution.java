package solution.lc_147_insertion_sort_list;

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
}	