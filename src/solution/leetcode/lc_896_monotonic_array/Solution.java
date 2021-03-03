package solution.leetcode.lc_896_monotonic_array;

/**
 * @author chenglong.yu
 * created on 2021/2/28
 */
public class Solution {



    public boolean isMonotonic(int[] A) {
        if (null == A || A.length == 0) {
            return false;
        } else if (A.length == 1) {
            return true;
        } else {
            int len = A.length;
            boolean incr = true, desc = true;
            for (int i = 1; i < len; i++) {
                if (A[i - 1] < A[i]) {
                    desc = false;
                }
                if (A[i - 1] > A[i]) {
                    incr = false;
                }
            }

            return desc || incr;
        }
    }
}
