package solution.lc_128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/6/6
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> allElementSet = new HashSet<>();

        for (int n : nums) {
            allElementSet.add(n);
        }

        int longestLen = 0;
        for (int n : nums) {
            if (!allElementSet.contains(n - 1)) {
                int curElement = n;
                int curLen = 0;
                while(allElementSet.contains(curElement)) {
                    curElement += 1;
                    curLen += 1;
                }

                longestLen = Math.max(longestLen, curLen);
            }
        }

        return longestLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int len = s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(len);
    }
}
