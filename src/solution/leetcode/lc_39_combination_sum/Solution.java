package solution.leetcode.lc_39_combination_sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/9
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Deque<Integer> combination = new ArrayDeque<>();
        helper(candidates, 0, target, combination, res);
        return res;
    }

    /**
     * 此处可以与leetcode 77 做对比。
     * 77题中，回溯循环是这么写：
     private void backtrack(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
         if (path.size() == k) {
         res.add(new ArrayList<>(path));
         return;
         }
        for (int i = start; i <= (n - (k - path.size()) + 1); i++) {
            path.addLast(i);
            backtrack(n, k, i +1, path, res);
            path.removeLast();
        }
     }
     因为77题目要求是找组合、同一个元素不能出现两次，因此在 backtrack(n, k, i +1, path, res)里，是i+1，保证回溯进入下一层时，
     path从新的元素开始、不会有重复元素。

     而本题不限制元素出现次数，需要找重复出现的情况，因此helper(candidates, i, target - candidates[i], combination, res);
     即，进入下一层时，起始节点还是从当前层的起始节点开始。

     *
     * @param candidates
     * @param start
     * @param target
     * @param combination
     * @param res
     */
    private void helper(int[] candidates, int start, int target, Deque<Integer> combination, List<List<Integer>> res) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.addLast(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, res);
            combination.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> combination = new ArrayDeque<>();
        helper2(candidates, 0, target, combination, res);
        return res;
    }

    private void helper2(int[] candidates, int start, int target, Deque<Integer> combination, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                /*
                由于候选数组已经有序，当前第i个元素已经不能满足题目要求，那么后面的第i+1/i+2/...的元素都不能，
                所以直接break，将省去当前、以及后面i+1/i+2/...等元素的回溯，剪枝。
                 */
                break;
            }
            combination.addLast(candidates[i]);
            helper2(candidates, i, target - candidates[i], combination, res);
            combination.removeLast();
        }
    }
}
