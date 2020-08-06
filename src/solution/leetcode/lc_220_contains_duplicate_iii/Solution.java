package solution.leetcode.lc_220_contains_duplicate_iii;

import java.util.TreeSet;

/**
 * @author chenglong.yu
 * created on 2019/9/25
 */
public class Solution {

    /**
     * 算法1：双重循环，每一步都计算k次，复杂度为O(N*K),很机械
     * 算法2：优化算法1，本质相同，目标都是从原有数组中不断挪动窗口，看窗口内是否有满足
     * 限制条件的数据。那么，首先假定已经选好窗口了，我们需要比较在窗口内的数字，看是否有
     * 相等的情况，而这个逻辑可以通过将窗口内元素排序、比较相邻元素来实现，因为算法1重复、无效
     * 的计算量主要是因为没有排序，排序后只要比较比当前元素小的最大元素、比当前元素大的最小元素。
     * 而排序的话，可以拿现有数据结构，下面算法则采用了TreeMap(内部利用了红黑树)，保证了高效。
     * 最后，i挪动超过k时，每挪动一次，就删除一个元素，保证窗口内元素总是k个。
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}
