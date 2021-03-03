package solution.leetcode.lc_1727_largest_submatrix_with_rearrangements;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2021/1/21
 */
public class Solution {
    /**
     *
     作者：rational-irrationality
     链接：https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements/solution/java-yu-chu-li-shu-zu-bian-li-mei-xing-p-qpqu/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     * @param matrix
     * @return
     */
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            Arrays.sort(matrix[i]);
            for (int j = col - 1; j >= 0; j--) {
                //更新矩形的最大高度
                int height = matrix[i][j];
                //更新最大面积
                res = Math.max(res, height * (col - j));
            }
        }
        return res;
    }
}
