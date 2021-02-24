package solution.leetcode.lc_832_flip_image;

/**
 * @author chenglong.yu
 * created on 2021/2/24
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(s.flipAndInvertImage(A));

    }
}
