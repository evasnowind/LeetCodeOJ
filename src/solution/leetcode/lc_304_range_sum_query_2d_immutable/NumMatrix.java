package solution.leetcode.lc_304_range_sum_query_2d_immutable;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources_fr;

/**
 * @author chenglong.yu
 * created on 2021/3/3
 */
public class NumMatrix {

    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            int row = matrix.length;
            int col = matrix[0].length;

            prefixSum = new int[row+1][col+1];
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2+1][col2+1] - prefixSum[row1][col2+1] - prefixSum[row2+1][col1] + prefixSum[row1][col1];
    }
}
