package solution.leetcode.lc_78_subset;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/20
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return res;
        }

        Deque<Integer> path = new LinkedList<>();
        backtrack(nums, 0, path, res);

        return res;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3};
        List res = s.subsets(nums);
        System.out.println(res);
    }
}
