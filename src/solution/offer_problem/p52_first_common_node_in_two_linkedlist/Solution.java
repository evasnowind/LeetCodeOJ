package solution.offer_problem.p52_first_common_node_in_two_linkedlist;

/**
 * @author chenglong.yu
 * created on 2020/10/15
 */
public class Solution {

    /**
     * 很典型的一个动图解析参见
     * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
     *
     * 本题思路：
     * 思路1：计算两个链表的长度（假设长度分别是m/n），然后第2次遍历，快指针先走m-n步，然后两个指针再开始同时走。直到两者相遇
     * 思路2：利用hashset保存1个链表的所有节点，然后从头开始遍历另一个链表，遍历时发现的第一个节点即为所求
     * 思路3：比较巧妙的思路，分别用node1 node2指向两个链表，然后同时开始遍历，当遍历到尽头时换一个链表继续遍历，理解这个算法的关键是
     * 这种换链表继续遍历的做法，可以保证node1 node2走过相同的长度，那么最后相交的几个节点必然会相遇。有点类似于思路1，
     * node1 node2都遍历完当前链表、做过切换后，其实就是利用一个循环内的一次遍历，找出了链表1、链表2之间相差多少个节点，都切换后
     * 实际上node1 node2到末尾的距离都相等，只是可能尚未相交、所以两个节点可能不等，因此需要继续遍历，直至node1=node2，即找到所求。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while(node1 != node2) {
            if (null != node1) {
                node1 = node1.next;
            } else {
                node1 = headB;
            }
            if (null != node2) {
                node2 = node2.next;
            } else {
                node2 = headA;
            }
        }
        return node1;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
}