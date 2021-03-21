package solution.leetcode.lc_73_set_zeros;

/**
 * @author chenglong.yu
 * created on 2021/3/21
 */
public class Solution {

    /**
     * 方案1：
     * 创建一个矩阵m，先遍历matrix一次，找到所有为0的
     * 索引位置，将m中对应位置置为true。
     * 然后遍历m，只要m中某个位置已被标记，则matrix对应行、列都置为0.
     * 时间复杂度：O(N*M)
     * 空间复杂度：O(N*M)
     *
     * 方案2：
     * 简化方案1，由于只要某行或是某列出现一个0，那么当前行、列都会置为0.
     * 我们只需要记录某行、某列中是否有出现过0.
     * 因此创一个行记录数组ma, 列记录数组na。
     * 第一次遍历matrix, 如果发现matrix[i][j]=0, 则ma[i]= na[j]=0
     * 第二次遍历matrix，如果ma[i]或是na[j]=0，则matrix[i][j]=0
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M+N)
     *
     * 方案3：
     * 进一步简化，使用matrix第1行、第1列替换掉方案2中额外数组。
     * 这里没太想明白，参见https://leetcode-cn.com/problems/set-matrix-zeroes/solution/ju-zhen-zhi-ling-by-leetcode-solution-9ll7/
     *
     *
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] ma = new boolean[m];
        boolean[] na = new boolean[n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ma[i] = na[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (ma[i] || na[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
