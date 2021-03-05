package solution.leetcode.lc_697_degree_of_array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenglong.yu
 * created on 2021/2/20
 */
public class Solution {


    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxNum = 0, minLen = 0;
        for(Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] vals = entry.getValue();
            if (vals[0] > maxNum) {
                maxNum = vals[0];
                minLen = vals[2] - vals[1] + 1;
            } else if (vals[0] == maxNum) {
                minLen = Math.min(vals[2] - vals[1] + 1, minLen);
            }
        }

        return minLen;
    }
}
