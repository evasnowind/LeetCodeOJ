package solution.leetcode.lc_435_non_overlap_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenglong.yu
 * created on 2020/12/31
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }
        return n - res;
    }
}
