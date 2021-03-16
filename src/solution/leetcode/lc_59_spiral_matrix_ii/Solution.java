package solution.leetcode.lc_59_spiral_matrix_ii;

/**
 * @author chenglong.yu
 * created on 2021/3/16
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while(left <= right && top <= bottom) {
            for(int col = left; col <= right; col++) {
                res[top][col] = num;
                num++;
            }
            for(int row = top + 1; row <= bottom; row++) {
                res[row][right] = num;
                num++;
            }

            if (left < right && top < bottom) {
                for(int col = right - 1; col > left; col--) {
                    res[bottom][col] = num;
                    num++;
                }
                for(int row = bottom; row > top; row--) {
                    res[row][left] = num;
                    num++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
