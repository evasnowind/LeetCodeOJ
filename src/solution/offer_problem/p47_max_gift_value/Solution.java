package solution.offer_problem.p47_max_gift_value;

import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2020/11/19
 */
public class Solution {


    int[] directX = new int[] {0, 1};
    int[] directY = new int[] {1, 0};

    int maxVal = 0;

    /**
     *
     * 动态规划：
     * f(0,0) = grid[0][0]
     * f(i, j) = max(f(i-1, j), f(i, j-1)) + grid[i][j]
     * f(i, 0) = f(i-1, 0) + grid[i][0]
     * f(0, j) = f(0, j-1) + grid[0][j]
     *
     * 进一步优化：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
     *
     * 节省了空间
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        int[][] matrix = new int[row][col];
        matrix[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            matrix[i][0] =  matrix[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            matrix[0][i] = matrix[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = Math.max(matrix[i][j-1], matrix[i-1][j]) + grid[i][j];
            }
        }

        return matrix[row - 1][col - 1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int max = s.maxValue(grid);
        System.out.println(max);
    }
}
