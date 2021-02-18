package solution.leetcode.lc_566_reshape_matrix;

/**
 * @author chenglong.yu
 * created on 2021/2/17
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length, col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }

        int[][] matrix = new int[r][c];
        int idx = 0;
        int ni = 0, nj = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ni = idx / c;
                nj = idx % c;
                matrix[ni][nj] = nums[i][j];
                idx++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1,2},{3,4}};

        Solution s = new Solution();
        int[][] m2 = s.matrixReshape(m1, 1, 4);
        System.out.println(m2);
    }
}
