package solution.leetcode.lc_60_permutation_sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/5
 */
public class Solution {




    public String getPermutation(int n, int k) {
        int [] factorial = getFactorial(n);
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(factorial, used, n, k, 0, path);
        return path.toString();
    }

    public void dfs(int[] factorial, boolean[] used, int n, int k, int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k = k - cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(factorial, used, n, k, index + 1, path);
            //此处没必要回溯，感觉就是一个深度优先，一股脑走到头，也就拿到结果了

            return;
        }
    }

    private int[] getFactorial(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        return factorial;
    }

    private List<String> getAllPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }


        List<String> res = new ArrayList<>();
        backtrack(nums, res, 0);
        return res;
    }

    private void backtrack(int[] nums, List<String> res, int pos) {
        if (pos == nums.length) {
            StringBuilder builder = new StringBuilder();
            for (int num : nums) {
                builder.append(num);
            }
            res.add(builder.toString());
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            swap(nums, i, pos);
            backtrack(nums, res, pos + 1);
            swap(nums, i, pos);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = s.getAllPermutation(4,9);
        System.out.println(list);
    }
}
