package solution.oj_129_root_to_leaf_numbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu@100credit.com
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);

        Solution s = new Solution();
        int retVal = s.sumNumbers2(node);
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
