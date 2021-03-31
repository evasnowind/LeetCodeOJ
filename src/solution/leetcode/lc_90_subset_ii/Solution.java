package solution.leetcode.lc_90_subset_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/3/31
 */
public class Solution {


    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    /**
     *

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    private void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        dfs(false, cur + 1, nums);

        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }

        t.add(nums[cur]);

        dfs(true, cur + 1, nums);

        t.remove(t.size() - 1);
    }
}
