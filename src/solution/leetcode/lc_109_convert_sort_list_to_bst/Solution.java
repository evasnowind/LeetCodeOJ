package solution.leetcode.lc_109_convert_sort_list_to_bst;


import javax.swing.tree.TreeNode;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode() {}
    }

	class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x){val = x;}
	}

    /*
     * 参考https://discuss.leetcode.com/topic/35997/share-my-java-solution-1ms-very-short-and-concise
     *
     * https://discuss.leetcode.com/topic/8141/share-my-o-1-space-and-o-n-time-java-code
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) {
            return null;
        }
        return buildBST(head, null);
    }


    public TreeNode buildBST(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }

    /**
     * 利用中序遍历
     * 讲解参见 https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/you-xu-lian-biao-zhuan-huan-er-cha-sou-suo-shu-1-3/
     *
     * 下面这个链接有图，推荐看看
     * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/shou-hua-tu-jie-san-chong-jie-fa-jie-zhu-shu-zu-ku/
     */
    ListNode globalHead;
    public int getLength(ListNode head) {
        int len = 0;
        while(null != head) {
            len += 1;
            head = head.next;
        }
        return len;
    }

    public TreeNode buildTree2(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree2(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree2(mid + 1, right);
        return root;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree2(0, length - 1);
    }
}
