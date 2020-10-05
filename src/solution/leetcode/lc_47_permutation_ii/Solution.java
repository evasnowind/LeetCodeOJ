package solution.leetcode.lc_47_permutation_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/18
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return res;
        }

        Deque<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        getPermutation(nums, 0, res, path, visited);
        return res;
    }

    private void getPermutation(int[] nums, int depth, List<List<Integer>> res, Deque<Integer> path, boolean[] visited) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            path.addLast(nums[i]);
            getPermutation(nums, depth + 1, res, path, visited);
            visited[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res = s.permuteUnique(nums);
        System.out.println(res);
    }
}
