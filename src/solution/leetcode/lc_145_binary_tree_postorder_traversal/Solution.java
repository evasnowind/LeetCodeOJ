package solution.leetcode.lc_145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 后序遍历的非递归实现是先/中/后序非递归中最难的
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (null == root) return res;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode curNode = root, lastNode = null;
        while (null != curNode) {
            nodeStack.push(curNode);
            curNode = curNode.left;
        }
        while (!nodeStack.isEmpty()) {
            curNode = nodeStack.pop();
            if (null == curNode.right || curNode.right == lastNode) {
                res.add(curNode.val);
                lastNode = curNode;
            } else {
                nodeStack.push(curNode);
                curNode = curNode.right;
                while (null != curNode) {
                    nodeStack.push(curNode);
                    curNode = curNode.left;
                }
            }
        }
        return res;
    }

    /**
     * 非递归实现有两种：
     * 1、自己用栈来手工模拟递归的功能
     * 2、Morris算法
     *
     * 下面是采用手工模拟栈的方式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (null == root) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        while(null != root || !stack.isEmpty()) {
            while(null != root) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            /*
            1、null == root.right
            说明当前root节点已遍历完左、中，且没有右孩子，应该加入到结果中
            用pre记录已经后序遍历的上一个节点，留作后面判断有右孩子、且右孩子已遍历完的情况

            2、pre == root.right
            pre == root.right，说明右孩子已遍历，按后续遍历定义，此时需要遍历当前root节点

            3、其他情况，说明当前节点的左、中还没有遍历到，需要写入到栈中，以便模拟栈递归操作
             */
            if (null == root.right || pre == root.right) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }
}
