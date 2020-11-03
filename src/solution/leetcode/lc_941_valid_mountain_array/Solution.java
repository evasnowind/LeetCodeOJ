package solution.leetcode.lc_941_valid_mountain_array;

/**
 * @author chenglong.yu
 * created on 2020/11/3
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        if (null == A || A.length < 3) {
            return false;
        }

        int i = 1;
        boolean hasAscend = false, hasDescend = false;
        while(i < A.length && A[i-1] < A[i]) {
            i++;
            if (!hasAscend) {
                hasAscend = true;
            }
        }
        while(i < A.length && A[i-1] > A[i]) {
            i++;
            if (!hasDescend) {
                hasDescend = true;
            }
        }
        if (i == A.length && hasAscend && hasDescend) {
            return true;
        }
        return false;
    }

    /**
     *
     * https://leetcode-cn.com/problems/valid-mountain-array/solution/you-xiao-de-shan-mai-shu-zu-by-leetcode-solution/
     *
     * @param A
     * @return
     */
    public boolean validMountainArray2(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }
}
