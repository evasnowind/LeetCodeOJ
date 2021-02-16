package solution.offer_problem.p04_find_number_in_2d_matrix;

/**
 * @author chenglong.yu
 * created on 2021/2/16
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int i = row - 1, j = 0;
        boolean res = false;
        while(i >= 0 && j < col) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                res = true;
                break;
            }
        }
        return res;
    }
}
