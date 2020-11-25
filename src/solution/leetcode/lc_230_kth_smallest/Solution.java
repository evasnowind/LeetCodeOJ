package solution.leetcode.lc_230_kth_smallest;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/11/22
 */
public class Solution {

    /**
     *
     *
     * 需要充分利用BST这个条件。
     * BST最大特点是中序遍历时是升序的。
     * 思路1：中序遍历，保存遍历结果，得到中序数组，需要额外的O(N)空间
     * 思路2：我们实际上只是要拿到第k个节点，不是整个数组，因此可以直接在遍历过程中判断是否已经到了第k个元素。
     * 如果拿到目标后，直接终止遍历过程，可以省去一些计算。
     * 类似的题目还有如何拿到BST中第k大的数，此时从右向左遍历即可
     * 中序遍历又可以采用递归、非递归两种形式。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        inorderTraverse(root, k);
        return res.val;
    }

    private int cnt = 0;
    private TreeNode res;
    private void inorderTraverse(TreeNode root, int k) {
        if (null == root) {
            return;
        }

        inorderTraverse(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root;
            return;
        }
        inorderTraverse(root.right, k);
    }


    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || null != cur) {
            while(null != cur) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (0 == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}

    public TreeNode(int x) {
        val = x;
    }
}
