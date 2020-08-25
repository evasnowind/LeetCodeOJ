package solution.leetcode.lc_491_increasing_subsequences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/8/25
 */
public class Solution {

    LinkedList<Integer> temp = new LinkedList<>();
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (null == nums || nums.length == 0) {
            return answer;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return answer;
    }

    private void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                answer.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur+1, nums[cur], nums);
            temp.removeLast();
        }
        if (nums[cur] != last) {
            dfs(cur+1, last, nums);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{4, 6, 7, 7};
        Solution s = new Solution();
        s.findSubsequences(input);
    }
}
