package solution.leetcode.lc_976_largest_perimeter_triangle;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/11/29
 */
public class Solution {

    /**
     * 注意，只需要判断一个条件 a+b>c即可
     * 并不需要 a+b>c a-b<c同时判断，这两个条件是等价的
     * 因为a+b>c成立时，等价与a>c-b
     *
     * 为了更迅速找出结果，很自然的会想到排序，然后从最大
     * 的3个数，向比较小的数开始遍历，只要找到一个符合a+b>c
     * 就找到了题解。
     *
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            /*
            我们已经排序，如果A[i-2]+A[i-1]相加都比A[i]小，
            那么A[i-3]等更小的两个元素不可能比A[i]还大。
            因此不用考虑，直接拖动i，抛弃掉后面的元素，考虑更
            小的三元组
             */
            if (A[i-1] + A[i-2] > A[i]) {
                return A[i-1] + A[i-2] + A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = null;
//        A = new int[]{2,1,2};
//        s.largestPerimeter(A);

        A = new int[]{1,2,1};
        s.largestPerimeter(A);
    }
}
