package solution.offer_problem.p07_build_tree_by_pre_and_in_order_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/11/17
 */
public class Solution {

    /**
     * 经典问题
     * 先从先序数组找到第一个根，然后在中序数组定位该元素，
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder) {
            return null;
        }
        Map<Integer, Integer> inorderIdxMap = new HashMap<>();
        int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inorderIdxMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, len - 1,
                inorder, 0, len - 1, inorderIdxMap);
    }


    private TreeNode buildSubTree(int[] preorder, int prestart, int preend,
                                  int[] inorder, int instart, int inend, Map<Integer, Integer> locationMap) {
        if (prestart > preend || prestart < 0) {
            return null;
        } else if (prestart == preend) {
            return new TreeNode(inorder[inend]);
        }

        int rootIdx = locationMap.get(preorder[prestart]);
        int leftLen = rootIdx - instart;
        int rightLen = inend - rootIdx;

        TreeNode root = new TreeNode(preorder[prestart]);

        root.left = buildSubTree(preorder, prestart+1, prestart + leftLen,
                inorder, instart, rootIdx - 1, locationMap);
        root.right = buildSubTree(preorder, preend - rightLen + 1, preend,
                inorder, rootIdx + 1, inend, locationMap);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = new int[]{1,2,3,4,5,6};
        int[] inorder = new int[]{3,2,4,1,5,6};
        s.buildTree(preorder, inorder);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}