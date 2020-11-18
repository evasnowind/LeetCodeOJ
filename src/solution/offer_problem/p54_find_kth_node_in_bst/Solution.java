package solution.offer_problem.p54_find_kth_node_in_bst;

/**
 * @author chenglong.yu
 * created on 2020/11/17
 */
public class Solution {
    /**
     * 方案1：使用堆排序，创建一个优先级队列用作小顶堆，不过这个思路有些绕远。适合在给出数据是数组的情况
     * 方案2：由于题目输入是一个BST，就需要从该数据结构本身的特点来考虑，BST最重要的特点：中序遍历时是按顺序排列。
     * 那可以考虑反中序遍历（因为要求的是第k大的数，因此需要从大到小排列，从右往左遍历），将结果保存到一个数组中，第k-1个数即为所求。
     * 方案3：更进一步，并不一定非要保存整个队列，只要找到第k大的数即可，那么可以考虑在从右到左中序遍历过程中做计数，
     * 计数到k时的节点即为所求。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return resultNode.val;
    }

    private int num = 0;
    private TreeNode resultNode;

    private void dfs(TreeNode root, int k) {
        if (null == root) {
            return;
        }

        dfs(root.right, k);
        num++;
        if (num == k) {
            resultNode = root;
            return;
        }
        dfs(root.left, k);
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