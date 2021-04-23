package solution.leetcode.lc_363_max_sum_of_rectangle_no_larger_than_k;

import java.util.TreeSet;

/**
 * @author chenglong.yu
 * created on 2021/4/22
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/ju-xing-qu-yu-bu-chao-guo-k-de-zui-da-sh-70q2/
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for(int j = i; j < m; j++) {
                for(int c = 0; c < n; c++) {
                    //更新每列的元素和
                    sum[c] += matrix[j][c];
                }

                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for(int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        res = Math.max(res, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return res;
    }
}
