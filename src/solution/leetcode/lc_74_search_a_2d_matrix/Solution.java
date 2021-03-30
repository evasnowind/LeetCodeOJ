package solution.leetcode.lc_74_search_a_2d_matrix;

/**
 * @author chenglong.yu
 * created on 2021/3/30
 */
public class Solution {

    /**
     *
     * 方案1：
     * 观察矩阵特点，第一列从上到下是递增的，然后每一行也是递增的。
     * 可以用两次二分查找，第一次在第一列上，确定哪一行有可能包含target；
     * 第二次在这一行上进行，如果找不到那就说明肯定没有。
     *
     * 方案2：
     * 将整个矩阵映射到一个一维数组，那就可以直接使用二分查找。
     *
     * 参考：
     * https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            //关键点在这里，可以保证mid能遍历所有元素
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
