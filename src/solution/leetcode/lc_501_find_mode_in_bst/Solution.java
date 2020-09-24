package solution.leetcode.lc_501_find_mode_in_bst;

import java.util.ArrayList;
import java.util.List;

public class Solution {



    int base, count, maxCount;
    List<Integer> answer = new ArrayList<>();

    /**
     * 简单思路：
     * 中序遍历，用一个hash表保存每个数字的出现次数。
     * 时间O(n) 但空间最坏为O(n)
     *
     * 优化1：通过在递归过程中，只保存/更新base/count/maxCount这几个变量，立即算出
     * 目前的众数、不用额外的hash表。（题目有提到，递归所用开销可以不算在内）
     *
     * 优化2：进一步优化递归，转成非递归遍历。但经典的非递归中序遍历需要额外用到一个栈，
     * 此时可以使用Morris算法，时间O(n) 空间O(1)。
     *
     * 上述两点结合，即可得到下面代码。
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;

        while(null != cur) {
            if (null == cur.left) {
                update(cur.val);
                cur = cur.right;
                continue;
            }

            pre = cur.left;
            while(pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (null == pre.right) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }

        int[] mode = new int[answer.size()];
        for (int i = 0; i < mode.length; i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    private void update(int x) {
        if (x == base) {
            count++;
        } else {
            count = 1;
            base = x;
        }

        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            answer.clear();
            answer.add(base);
            maxCount = count;
        }
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