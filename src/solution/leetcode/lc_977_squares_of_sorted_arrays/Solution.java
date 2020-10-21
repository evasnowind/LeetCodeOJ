package solution.leetcode.lc_977_squares_of_sorted_arrays;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/10/16
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        if (null == A || A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

    public int[] sortedSquares2(int[] A) {
        if (null == A || A.length == 0) {
            return A;
        }
        int n = A.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, pos = n - 1;
        /*
        由于是递增的，平方后最大的值只可能出现在数组两边，因此只需比较两边的结果、
        然后i j逐步向中间逼近
         */
        while (i <= j) {
            if (A[i] * A[i] > A[j] * A[j]) {
                res[pos] = A[i] * A[i];
                i++;
            } else {
                res[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return res;
    }

    public int[] sortedSquares3(int[] A) {
        if (null == A || A.length == 0) {
            return A;
        }
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                /*
                找到原数组A中正数、负数分界点
                 */
                negative = i;
            } else {
                break;
            }
        }

        int[] res = new int[n];
        int pos = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                res[pos] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                res[pos] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                res[pos] = A[i] * A[i];
                --i;
            } else {
                res[pos] = A[j] * A[j];
                ++j;
            }
            ++pos;
        }
        return res;
    }
}
