package solution.leetcode.lc_1438_longest_continuous_subarray_with_abs_diff_less_than_or_equal_to_limit;

import java.util.TreeMap;

/**
 * @author chenglong.yu
 * created on 2021/2/21
 */
public class Solution {

    /**
     * 思路1：
     * 先易后难，如果没有其他思路，那就先从暴力破解开始思考。
     * 可以想见，暴力破解情况下，需要先找出所有子数组，然后计算每个
     * 子数组任意元素之间的最大绝对值，看是否满足<=limit条件。
     * 找出所有子数组 O(N^2)
     * 如果直接任何组合都算，那又是一个最坏O(N^2)，当然这个可以简化一些，
     * 利用有序集合，比如TreeMap，来保存子数组，那么计算绝对值时只需要
     * 计算最大、最小的差值即可。
     *
     * 思路2：
     * 暴力破解肯定会超时。
     * 看题目要求，是连续子数组求最值，很符合使用滑动窗口。
     * ——这个联想就得多联系、多自己体会了
     * 滑动窗口同样面临子数组求最大绝对值的问题，那么采用上面说的
     * 有序集合保存子数组，
     * 即滑动窗口+有序集合
     * 滑动时，有序集合作为窗口，计算绝对值就很容易。
     * 考虑到可能有重复数字，有序集合采用<key,val>=<数组值, 出现次数>
     *
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        if (len == 1) {
            return len;
        }

        int left = 0, right = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;

        while(right < len) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.lastKey() - map.firstKey() > limit) {
                /*
                窗口内最大绝对值不符合要起，需要滑动左边界。
                而左边界left与right起点相同，因此在left必然
                已经放入到map中，我们只需要将其出现次数减一，
                若为0则将其移除。
                 */
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
