package solution.leetcode.lc_129_root_to_leaf_numbers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author chenglong.yu
 * created on 2020/5/8
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        LinkedList<Integer> prefixList = new LinkedList<>();
        ArrayList<Integer> numList = new ArrayList<>();

        getLeafNum(root, prefixList, numList);

        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int ancestorVal) {
        if (null == root) {
            return 0;
        }
        int tmp = ancestorVal * 10 + root.val;
        if (null == root.left && null == root.right) {
            return tmp;
        }
        return helper(root.left, tmp) + helper(root.right, tmp);
    }

    private void getLeafNum(TreeNode root, LinkedList<Integer> prefixList, ArrayList<Integer> numList) {
        if (null == root) {
            return;
        }

        prefixList.add(root.val);

        if (null == root.left && null == root.right) {
            //到达叶子节点，保存一个数字
            int tmpNum = 0;
            Iterator<Integer> iterator = prefixList.iterator();
            while (iterator.hasNext()) {
                Integer curNum = iterator.next();
                tmpNum = tmpNum * 10 + curNum;
            }
            numList.add(tmpNum);
            prefixList.removeLast();
            return;
        }

        getLeafNum(root.left, prefixList, numList);
        getLeafNum(root.right, prefixList, numList);

        prefixList.removeLast();
    }

    /**
     * 利用回溯算法模板算出每个数，然后汇总
     * @param root
     * @return
     */
    public int sumNumbers3(TreeNode root) {
        LinkedList<Integer> prefixList = new LinkedList<>();
        ArrayList<Long> numList = new ArrayList<>();

        getLeafNum2(root, prefixList, numList);

        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }
        return sum;
    }


    /**
     * 利用回溯算法模板算出每个数，然后汇总
     * @param root
     * @param prefixList
     * @param res
     */
    private void getLeafNum2(TreeNode root, LinkedList<Integer> prefixList, ArrayList<Long> res) {
        if (null == root) {
            return;
        }

        if (null != root && null == root.left && null == root.right) {
            long tmp = 0;
            prefixList.add(root.val);
            for (int num : prefixList) {
                tmp = tmp * 10 + num;
            }
            prefixList.removeLast();
            res.add(tmp);
            return;
        }

        prefixList.addLast(root.val);
        getLeafNum2(root.left, prefixList, res);
        getLeafNum2(root.right, prefixList, res);
        prefixList.removeLast();
    }

    /**
     * 广度优先遍历（按层遍历）
     * @param root
     * @return
     */
    public int sumNumber4(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int sum = 0;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();

            TreeNode left = node.left, right = node.right;
            if (null == left && null == right) {
                //叶子节点，找到一条路径
                sum += num;
            } else {
                /*
                非叶子节点，需要将当前节点数字*10，然后入队，以便后面使用。
                num是上次BFS的结果，也就是当前从根节点走到当前节点之前，这条
                路径的和，接下来只需要将num*10，然后加上当前节点，就得到当前
                路径和，入队，准备下次BFS。
                 */
                if (null != left) {
                    numQueue.offer(left.val + num * 10);
                    nodeQueue.offer(left);
                }
                if (null != right) {
                    numQueue.offer(right.val + num * 10);
                    nodeQueue.offer(right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        Solution s = new Solution();
        int retVal = s.sumNumber4(node);
        System.out.println(retVal);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
